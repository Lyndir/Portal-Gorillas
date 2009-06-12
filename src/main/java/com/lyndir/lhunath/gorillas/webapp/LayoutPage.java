package com.lyndir.lhunath.gorillas.webapp;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;

import org.apache.wicket.RestartResponseException;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.behavior.HeaderContributor;
import org.apache.wicket.behavior.StringHeaderContributor;
import org.apache.wicket.extensions.markup.html.tabs.AbstractTab;
import org.apache.wicket.extensions.markup.html.tabs.ITab;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.CSSPackageResource;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.template.JavaScriptTemplate;
import org.apache.wicket.util.template.TextTemplate;


public class LayoutPage extends WebPage {

    private static final long   serialVersionUID  = 1L;
    private static final String DEFAULT_THEME     = "gray";
    private static final String COOKIE_THEME_NAME = "layout.theme";

    static List<ITab>           headTabsList;
    static List<String>         themesList;
    static {
        headTabsList = new ArrayList<ITab>( 2 );
        headTabsList.add( new AbstractTab( new Model<String>( "Demo" ) ) {

            @Override
            public Panel getPanel(String wicketId) {

                return new DemoPanel( wicketId );
            }
        } );
        headTabsList.add( new AbstractTab( new Model<String>( "About" ) ) {

            @Override
            public Panel getPanel(String wicketId) {

                return new AboutPanel( wicketId );
            }
        } );
        headTabsList.add( new AbstractTab( new Model<String>( "Archives" ) ) {

            @Override
            public Panel getPanel(String wicketId) {

                return new ArchivePanel( wicketId );
            }
        } );
        headTabsList.add( new AbstractTab( new Model<String>( "Original" ) ) {

            @Override
            public Panel getPanel(String wicketId) {

                return new OriginalPanel( wicketId );
            }
        } );
        headTabsList.add( new AbstractTab( new Model<String>( "Trac" ) ) {

            @Override
            public Panel getPanel(String wicketId) {

                throw new RestartResponseException( TracPage.class );
            }
        } );

        themesList = new ArrayList<String>( 2 );
        themesList.add( DEFAULT_THEME );
        themesList.add( "blue" );
        themesList.add( "green" );
    }

    int                         selectedTabIndex;
    HeaderContributor           selectedTheme;
    WebMarkupContainer          headTabsContainer;


    /**
     * @param pageTitle
     *            The contents of the <code>title</code> tag.
     * @param headTabsList
     *            A list of tabs to put in the header.
     */
    public LayoutPage() {

        if (headTabsList == null || headTabsList.isEmpty())
            throw new IllegalArgumentException( "headTabsList must not be null or empty." );

        // Page TITLE.
        Label pageTitle = new Label( "pageTitle", "Gorillas - " + getPageTitle() );

        // Page TABS.
        headTabsContainer = new WebMarkupContainer( "headTabsContainer" );
        ListView<ITab> headTabs = new ListView<ITab>( "headTabs", headTabsList ) {

            @Override
            protected void populateItem(ListItem<ITab> item) {

                final ITab headTab = item.getModelObject();

                Link<String> link = new AjaxFallbackLink<String>( "link" ) {

                    @Override
                    public void onClick(AjaxRequestTarget target) {

                        // TAB click.
                        selectedTabIndex = headTabsList.indexOf( headTab );
                        Panel contentPanel = headTab.getPanel( "contentPanel" );
                        contentPanel.setOutputMarkupId( true );

                        // OnShowJavaScript
                        String js = null;
                        if (contentPanel instanceof JavaScriptProvider)
                            js = ((JavaScriptProvider) contentPanel).getProvidedJavaScript();

                        LayoutPage.this.addOrReplace( contentPanel );

                        if (target != null) {
                            // AJAX Support
                            target.addComponent( contentPanel );
                            target.addComponent( headTabsContainer );

                            if (js != null)
                                target.appendJavascript( js );
                        } else {
                            // No AJAX Support
                            final String jsTemplate = js;

                            add( new StringHeaderContributor( new JavaScriptTemplate( new TextTemplate() {

                                @Override
                                public TextTemplate interpolate(Map<String, Object> variables) {

                                    return this;
                                }

                                @Override
                                public String getString() {

                                    return jsTemplate;
                                }
                            } ).asString() ) );
                        }
                    }
                };

                item.add( link );
                link.add( new Label( "title", headTab.getTitle() ) );
            }

            @Override
            protected ListItem<ITab> newItem(final int index) {

                return new ListItem<ITab>( index, getListItemModel( getModel(), index ) ) {

                    @Override
                    protected void onComponentTag(ComponentTag tag) {

                        super.onComponentTag( tag );
                        if (index == selectedTabIndex)
                            tag.put( "class", "active" );
                    }
                };
            }
        };
        ListView<String> themeTabs = new ListView<String>( "themeTabs", themesList ) {

            @Override
            protected void populateItem(ListItem<String> item) {

                final String theme = item.getModelObject();

                Link<String> link = new Link<String>( "link" ) {

                    @Override
                    public void onClick() {

                        setSelectedTheme( theme );
                    }

                    @Override
                    protected void onComponentTag(ComponentTag tag) {

                        super.onComponentTag( tag );

                        tag.put( "class", MessageFormat.format( "{0} button", theme ) );
                    }
                };

                item.add( link );
            }
        };
        headTabsContainer.add( headTabs, themeTabs );
        headTabsContainer.setOutputMarkupId( true );

        // Initial theme.
        setDefaultTheme();

        // Page content.
        Panel contentPanel = getDefaultPanel( "contentPanel" );
        contentPanel.setOutputMarkupId( true );

        add( pageTitle, headTabsContainer, contentPanel );
    }

    protected void setDefaultTheme() {

        if (selectedTheme != null)
            // A theme is already set; won't overwrite with default.
            return;

        // Default is either hard coded, or overridden by cookie.
        String theme = DEFAULT_THEME;
        Cookie cookie = getWebRequestCycle().getWebRequest().getCookie( COOKIE_THEME_NAME );
        if (cookie != null)
            theme = cookie.getValue();

        setSelectedTheme( theme );
    }

    protected void setSelectedTheme(final String theme) {

        if (selectedTheme != null)
            // A theme is already active, deactivate it first.
            getPage().remove( selectedTheme );

        // Remember this theme selection for next visit.
        Cookie cookie = new Cookie( COOKIE_THEME_NAME, theme );
        cookie.setMaxAge( Integer.MAX_VALUE );
        getWebRequestCycle().getWebResponse().addCookie( cookie );

        // Create and add the CSS header contribution that will render this theme.
        String themeStyleSheet = MessageFormat.format( "css/style_{0}.css", theme );
        selectedTheme = CSSPackageResource.getHeaderContribution( themeStyleSheet );
        getPage().add( selectedTheme );
    }

    /**
     * @param wicketId
     *            The wicket ID that the panel should have.
     * @return The {@link Panel} to show as the content before any tabs have been selected.
     */
    protected Panel getDefaultPanel(String wicketId) {

        return headTabsList.get( 0 ).getPanel( wicketId );
    }

    /**
     * @return The title string that describes this page.
     */
    protected String getPageTitle() {

        return "The iPhone Game";
    }
}
