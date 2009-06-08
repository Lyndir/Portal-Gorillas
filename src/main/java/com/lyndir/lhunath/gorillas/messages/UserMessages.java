/*
 *   Copyright 2009, Maarten Billemont
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package com.lyndir.lhunath.gorillas.messages;

import java.lang.reflect.Field;

import org.apache.wicket.Component;

import com.lyndir.lhunath.gorillas.webapp.GorillasWebApplication;
import com.lyndir.lhunath.lib.system.localization.Localizer;
import com.lyndir.lhunath.lib.system.localization.UseBundle;
import com.lyndir.lhunath.lib.system.localization.UseKey;


/**
 * <h2>{@link UserMessages}<br>
 * <sub>Localization interface for messages in the {@link GorillasWebApplication}.</sub></h2>
 * 
 * <p>
 * <i>Mar 29, 2009</i>
 * </p>
 * 
 * @see Localizer
 * 
 * @author lhunath
 */
@UseBundle("UserMessagesBundle")
public interface UserMessages {

    @UseKey
    String noMapping(Field injectionField, Class<? extends Component> injectionOwner);
}
