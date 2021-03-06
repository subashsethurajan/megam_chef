/* 
** Copyright [2012-2013] [Megam Systems]
**
** Licensed under the Apache License, Version 2.0 (the "License");
** you may not use this file except in compliance with the License.
** You may obtain a copy of the License at
**
** http://www.apache.org/licenses/LICENSE-2.0
**
** Unless required by applicable law or agreed to in writing, software
** distributed under the License is distributed on an "AS IS" BASIS,
** WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
** See the License for the specific language governing permissions and
** limitations under the License.
*/
package org.megam.chef.exception;

/**
 * Superclass of all the exceptions. All the thrown exceptions in megam_chef gets grouped to 
 * this class.
 * @author ram
 *
 */
public class MegamChefException extends Throwable {
	
	public MegamChefException(Throwable that) {
		super(that);
	}

}
