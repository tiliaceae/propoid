/*
 * Copyright 2011 Sven Meier
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package propoid.db.version.alter;

import propoid.db.schema.Column;

public class DropColumn extends AlterColumn {

	private String name;

	public DropColumn(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "drop column '" + name + "'";
	}

	@Override
	public boolean alters(Column column) {
		return column.name.equals(this.name);
	}

	@Override
	public Column alter(Column column) {
		return null;
	}
}