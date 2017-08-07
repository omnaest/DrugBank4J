package org.omnaest.metabolics.drugbank.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pharmacology
{
	@JsonProperty("indication_descripton")
	private String indicationDescription;

	@JsonProperty("pharmacodynamic_description")
	private String pharmacodynamicDescription;

	@JsonProperty("mechanism_of_action_description")
	private String mechanismOfActionDescription;

	@JsonProperty("absorption")
	private String absorption;

	@JsonProperty("protein_binding")
	private String proteinBinding;

	@JsonProperty("volume_of_distribution")
	private List<String> volumeOfDistribution;

	@JsonProperty("clearance")
	private List<String> clearance;

	@JsonProperty("half_life")
	private String halfTime;

	@JsonProperty("route_of_elimination")
	private String routeOfElimination;

	@JsonProperty("toxicity_description")
	private String toxicityDescription;

	public String getIndicationDescription()
	{
		return indicationDescription;
	}

	public void setIndicationDescription(String indicationDescription)
	{
		this.indicationDescription = indicationDescription;
	}

	public String getPharmacodynamicDescription()
	{
		return pharmacodynamicDescription;
	}

	public void setPharmacodynamicDescription(String pharmacodynamicDescription)
	{
		this.pharmacodynamicDescription = pharmacodynamicDescription;
	}

	public String getMechanismOfActionDescription()
	{
		return mechanismOfActionDescription;
	}

	public void setMechanismOfActionDescription(String mechanismOfActionDescription)
	{
		this.mechanismOfActionDescription = mechanismOfActionDescription;
	}

	public String getAbsorption()
	{
		return absorption;
	}

	public void setAbsorption(String absorption)
	{
		this.absorption = absorption;
	}

	public String getProteinBinding()
	{
		return proteinBinding;
	}

	public void setProteinBinding(String proteinBinding)
	{
		this.proteinBinding = proteinBinding;
	}

	public List<String> getVolumeOfDistribution()
	{
		return volumeOfDistribution;
	}

	public void setVolumeOfDistribution(List<String> volumeOfDistribution)
	{
		this.volumeOfDistribution = volumeOfDistribution;
	}

	public List<String> getClearance()
	{
		return clearance;
	}

	public void setClearance(List<String> clearance)
	{
		this.clearance = clearance;
	}

	public String getHalfTime()
	{
		return halfTime;
	}

	public void setHalfTime(String halfTime)
	{
		this.halfTime = halfTime;
	}

	public String getRouteOfElimination()
	{
		return routeOfElimination;
	}

	public void setRouteOfElimination(String routeOfElimination)
	{
		this.routeOfElimination = routeOfElimination;
	}

	public String getToxicityDescription()
	{
		return toxicityDescription;
	}

	public void setToxicityDescription(String toxicityDescription)
	{
		this.toxicityDescription = toxicityDescription;
	}

}
