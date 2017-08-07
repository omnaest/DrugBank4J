package org.omnaest.metabolics.drugbank;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.omnaest.metabolics.drugbank.domain.Drug;
import org.omnaest.metabolics.drugbank.utils.JSONHelper;
import org.omnaest.metabolics.drugbank.utils.RestHelper;
import org.omnaest.metabolics.drugbank.utils.filecache.ContentFolderBasedCache;
import org.omnaest.metabolics.drugbank.utils.filecache.ContentProvider;

public class DrugBankRESTUtils
{
	public static String BASE_URL = "https://api.drugbankplus.com/v1";

	public static interface DrugBankRestClient
	{
		public Drug getDrug(String drugId);
	}

	/**
	 * @see Region
	 * @author omnaest
	 */
	public static enum Regions implements Region
	{
		EU, US, CA;

		@Override
		public String code()
		{
			return this	.name()
						.toLowerCase();
		}
	}

	/**
	 * @see Regions
	 * @author omnaest
	 */
	public static interface Region
	{
		public String code();
	}

	public static interface ElementProvider<T>
	{
		public T get();
	}

	public static DrugBankRestClient getInstance(String apiKey, Region region, boolean cached)
	{
		return new DrugBankRestClient()
		{
			private Map<String, String>	headers	= generateHeaders();
			private String				baseUrl	= generateBaseUrl(region);

			@Override
			public Drug getDrug(String drugId)
			{
				return this.requestGet("drugs/" + drugId, Drug.class);
			}

			private <T> T requestGet(String path, Class<T> type)
			{
				return this.getCached(splitPath(path), new ContentProvider()
				{
					@Override
					public String get(String[] path)
					{
						return RestHelper.requestGet(baseUrl + "/" + joinPath(path), headers);
					}

					private String joinPath(String[] path)
					{
						return StringUtils.join(path, "/");
					}
				}, type);
			}

			private String[] splitPath(String path)
			{
				return StringUtils.split(path, "/");
			}

			private <T> T getCached(String[] path, ContentProvider provider, Class<T> type)
			{
				String content;
				if (cached)
				{
					content = new ContentFolderBasedCache<Drug>("cache", provider).get(path);
				} else
				{
					content = provider.get(path);
				}
				return JSONHelper.readFromString(content, type);
			}

			private String generateBaseUrl(Region region)
			{
				return region != null ? StringUtils.join(new String[] { BASE_URL, region.code() }, "/") : BASE_URL;
			}

			private HashMap<String, String> generateHeaders()
			{
				HashMap<String, String> retmap = new HashMap<>();
				retmap.put("Authorization", apiKey);
				return retmap;
			}
		};
	}

}
