package org.omnaest.metabolics.drugbank.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Identifiers
{
	@JsonProperty("drugbank_id")
	private String	drugBankId;
	@JsonProperty
	private String	inchi;
	@JsonProperty
	private String	inchikey;

	public String getDrugBankId()
	{
		return drugBankId;
	}

	public void setDrugBankId(String drugBankId)
	{
		this.drugBankId = drugBankId;
	}

	public String getInchi()
	{
		return inchi;
	}

	public void setInchi(String inchi)
	{
		this.inchi = inchi;
	}

	public String getInchikey()
	{
		return inchikey;
	}

	public void setInchikey(String inchikey)
	{
		this.inchikey = inchikey;
	}

}
