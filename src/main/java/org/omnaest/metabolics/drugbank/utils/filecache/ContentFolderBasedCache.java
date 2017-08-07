/*

	Copyright 2017 Danny Kunz

	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at

		http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.


*/
package org.omnaest.metabolics.drugbank.utils.filecache;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContentFolderBasedCache<T> implements ContentProvider
{
	private static Logger LOG = LoggerFactory.getLogger(ContentFolderBasedCache.class);

	protected File				directory;
	protected ContentProvider	provider;

	public ContentFolderBasedCache(String directory, ContentProvider provider)
	{
		this(new File(directory), provider);
	}

	public ContentFolderBasedCache(File directory, ContentProvider provider)
	{
		super();
		this.directory = directory;
		this.provider = provider;
	}

	public String get(String[] identifiers)
	{
		String retval = this.readFileContent(this.generateFileLocation(identifiers));
		if (retval == null)
		{
			retval = this.provider.get(identifiers);
			this.writeFileContent(this.generateFileLocation(identifiers), retval);
		}
		return retval;
	}

	private String readFileContent(File file)
	{
		try
		{
			return FileUtils.readFileToString(file, "utf-8");
		} catch (IOException e)
		{
			return null;
		}
	}

	private void writeFileContent(File file, String content)
	{
		try
		{
			FileUtils.writeStringToFile(file, content, "utf-8");
		} catch (IOException e)
		{
			LOG.error("Exception writing cache content to " + file.getAbsolutePath(), e);
		}
	}

	private File generateFileLocation(String[] identifiers)
	{
		return new File(this.directory, StringUtils.join(identifiers, "/"));
	}

}
