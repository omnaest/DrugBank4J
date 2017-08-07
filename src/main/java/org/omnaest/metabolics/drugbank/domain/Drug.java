package org.omnaest.metabolics.drugbank.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Drug
{
	@JsonProperty("drugbank_id")
	private String drugBankId;

	@JsonProperty
	private String name;

	@JsonProperty
	private String description;

	@JsonProperty
	private List<String> synonyms;

	@JsonProperty
	private Pharmacology pharmacology;

	@JsonProperty
	private Identifiers identifiers;

	public String getDrugBankId()
	{
		return drugBankId;
	}

	public void setDrugBankId(String drugBankId)
	{
		this.drugBankId = drugBankId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public List<String> getSynonyms()
	{
		return synonyms;
	}

	public void setSynonyms(List<String> synonyms)
	{
		this.synonyms = synonyms;
	}

	public Pharmacology getPharmacology()
	{
		return pharmacology;
	}

	public void setPharmacology(Pharmacology pharmacology)
	{
		this.pharmacology = pharmacology;
	}

	public Identifiers getIdentifiers()
	{
		return identifiers;
	}

	public void setIdentifiers(Identifiers identifiers)
	{
		this.identifiers = identifiers;
	}

}
