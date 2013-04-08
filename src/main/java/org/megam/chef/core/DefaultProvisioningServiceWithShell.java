/* 
** Copyright [2012] [Megam Systems]
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
package org.megam.chef.core;

import org.megam.chef.exception.ProvisionerException;
import org.megam.chef.exception.ShellException;
import org.megam.chef.parser.JSONRequest;
import org.megam.chef.parser.JSONRequestParser;
import org.megam.chef.shell.Command;
import org.megam.chef.shell.Shellable;
import org.megam.chef.shell.Stoppable;

/**
 * @author ram
 *
 */
public class DefaultProvisioningServiceWithShell<T>  extends DefaultProvisioningService implements Shellable, Stoppable{

	public DefaultProvisioningServiceWithShell() throws ProvisionerException{
		super();
	}
	
	/* (non-Javadoc)
	 * @see org.megam.chef.ProvisioningService#provision()
	 */
	@Override
	public T provision(String jsonString) throws ProvisionerException {	
		try { 
		execute(jsonToCommand(jsonString));
		/** we need a generic way to convert a Java output to JSON output **/
		} catch(ShellException she) {
			throw new ProvisionerException(she);
		}
		return null;
	}
	
	/**
	 * @param args
	 */
	public Command jsonToCommand(String jsonRequest) throws ShellException {
		return new org.megam.chef.shell.Command(convertInput(jsonRequest));
	}
	
	public void execute(Command that) throws ShellException {	
		/**
		 * We need to move this code to the following classes
		 * 
		 * Create ShellProvisioningPool, that has a run method which take a command and executes it.
		 *  
		 * addShellProvisioningListener
		 *   
		 * ShellEvent
		 */
				
	}

	/* (non-Javadoc)
	 * @see org.megam.shell.Stoppable#stop()
	 */
	@Override
	public void halt() {
		throw new RuntimeException("Halt not implemented yet.");
	}
	
	/**
	 * Using GSON library, an input JSON string is parsed to a
	 * GlobalConfiguration Java Object. If the JSON parameters passed are
	 * validated for 1..... 2. ..... 3. .... If they are valid then the shell builder builds a
	 * script. If not an error with the reasons of validation failure is retured.
	 * command
	 * 
	 * @param myJSONString
	 * @return
	 */
	private String convertInput(String jsonRequest) throws ShellException {
		JSONRequest jrp = (new JSONRequestParser(jsonRequest)).data();

		if (ParmsValidator.validate(jrp.conditionList())) {
			return ShellBuilder.buildString(jrp.scriptFeeder());
		} else {
			throw new ShellException(new IllegalArgumentException("Add the reason here"));
		}
	}

	
	
	public String toString() {
		//implement a toString;;
		return null;
	}

}
