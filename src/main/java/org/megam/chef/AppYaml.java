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
package org.megam.chef;

import java.util.Map;

/**
 * @author rajthilak
 *
 */
public class AppYaml {
	
    private static Map<String, String> yamlSource;    
	
    AppYaml(Map<String, String> type) {
    	this.yamlSource= type;    	
    }
    
    /**
     * 
     * @return
     */
	public String getSource() {
		// move all the variables to private static final  
    	return yamlSource.get("source");
    }
    
    public String getHost() {
    	return yamlSource.get("host");
    }
    
    public String getPort() {
    	return yamlSource.get("port");
    }
    
    public String getBucket() {
    	return yamlSource.get("bucket");
    }
    
    public String getConfig() {
    	return yamlSource.get("config");
    }
}