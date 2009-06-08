package com.lyndir.lhunath.gorillas.webapp;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.behavior.HeaderContributor;
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


public class LayoutPage extends WebPage {

    private static final long serialVersionUID = 1L;

    static List<ITab>         headTabsList;
    static List<String>       themesList;
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
        headTabsList.add( new AbstractTab( new Model<String>( "Original" ) ) {

            @Override
            public Panel getPanel(String wicketId) {

                throw new UnsupportedOperationException();
                // return new ProfileIntroPanel( wicketId );
            }
        } );

        themesList = new ArrayList<String>( 2 );
        themesList.add( "gray" );
        themesList.add( "blue" );
        themesList.add( "green" );
    }

    int                       selectedTabIndex;
    HeaderContributor         selectedTheme;
    WebMarkupContainer        headTabsContainer;


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

                        LayoutPage.this.addOrReplace( contentPanel );

                        if (target != null) {
                            target.addComponent( contentPanel );
                            target.addComponent( headTabsContainer );
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

                        // TAB click.
                        if (selectedTheme != null)
                            getPage().remove( selectedTheme );

                        String themeStyleSheet = MessageFormat.format( "css/style_{0}.css", theme );
                        selectedTheme = CSSPackageResource.getHeaderContribution( themeStyleSheet );
                        getPage().add( selectedTheme );
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

        // Page INTRO.
        Panel contentPanel = headTabsList.get( 0 ).getPanel( "contentPanel" );
        contentPanel.setOutputMarkupId( true );

        add( pageTitle, headTabsContainer, contentPanel );
    }

    /**
     * @return The title string that describes this page.
     */
    protected String getPageTitle() {

        return "The iPhone Game";
    }
}
