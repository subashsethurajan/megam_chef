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
package org.megam.chef.shell;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Command {
	private String inputCmd;
	private File rdo;
	private File rde;
	private List<String> cmdList = new ArrayList<String>();

	public Command(String s) {
		this.inputCmd = s;
		StringTokenizer st = new StringTokenizer(inputCmd);
		while (st.hasMoreTokens()) {
			cmdList.add(st.nextToken());
		}
	}

	public void setRedirectOutput(String trdo) {
		this.rdo = new File(trdo);
	}

	public File getRedirectOutputFile() {
		return rdo;
	}

	public String getRawCommandString() {
		return inputCmd;
	}

	public List<String> getCommandList() {
		return cmdList;
	}

	public void setRedirectError(String trde) {
		this.rde = new File(trde);
	}

	public File getRedirectErrorFile() {
		return rde;
	}

	public String toString() {
		return "(" + getCommandList() + ")";
	}
}