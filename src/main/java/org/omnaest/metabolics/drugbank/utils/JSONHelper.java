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
package org.omnaest.metabolics.drugbank.utils;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JSONHelper
{
	private final static Logger LOG = LoggerFactory.getLogger(JSONHelper.class);

	public static String prettyPrint(Object object)
	{
		String retval = null;
		try
		{
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

			retval = objectMapper.writeValueAsString(object);
		} catch (Exception e)
		{
			LOG.error("Error pretty printing json from object " + object, e);
		}
		return retval;
	}

	public static <T> T readFromString(String data, Class<T> type)
	{
		T retval = null;
		try
		{
			if (StringUtils.isNotBlank(data))
			{
				ObjectMapper objectMapper = new ObjectMapper();
				objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

				retval = objectMapper.readValue(data, type);
			}
		} catch (Exception e)
		{
			LOG.error("Error converting data string to json " + data, e);
		}
		return retval;
	}
}
