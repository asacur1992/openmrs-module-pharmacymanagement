/**
 * Auto generated file comment
 */
package org.openmrs.module.pharmacymanagement;

import java.util.Date;

import org.openmrs.Concept;
import org.openmrs.Drug;
import org.openmrs.Location;


/**
 *@author Dusabe Eric
 *to help in the display of the ARV Monthly Consumption
 */
public class Consommation {
	
	protected static Consommation instance;
	
	private String drugName;
	private String drugId;
	private Drug drug;
	private String conceptId;
	private Concept concept;
	private String forme;
	private String conditUnitaire;
	private int qntPremJour;
	private Object qntRecuMens;
	private Object qntConsomMens;
	private int qntRestMens;
	private int locationId;
	private Location location;
	private Date expirationDate;
	private DrugProduct drugProduct;
	private int stockOut;
	private int adjustMonthlyConsumption;
	private int maxQnty;
	private int qntyToOrder;
	private int returnedProduct;
	private int adjustedProduct;
	
	protected Consommation(int qntPremJour, Object qntRecuMens, Object qntConsomMens, int qntRestMens, Location location, DrugProduct drugProduct, int stockOut, int adjustMonthlyConsumption, int maxQnty, int qntyToOrder, int returnedProduct) {
		this.qntPremJour = qntPremJour;
		this.qntRecuMens = qntRecuMens;
		this.qntConsomMens = qntConsomMens;
		this.qntRestMens = qntRestMens;
		this.location = location;
		this.drugProduct = drugProduct;
		this.stockOut = stockOut;
		this.adjustMonthlyConsumption = adjustMonthlyConsumption;
		this.maxQnty = maxQnty;
		this.qntyToOrder = qntyToOrder;
		this.returnedProduct = returnedProduct;
	}
	
	public Consommation() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Gets the singleton instance
	 * @return
	 */
	public static Consommation getInstance() {
		return instance;
	}
	
	/**
	 * Creates the singleton instance
	 */
	public static Consommation createInstance(int qntPremJour, Object qntRecuMens, Object qntConsomMens, int qntRestMens, Location location, DrugProduct drugProduct, int stockOut, int adjustMonthlyConsumption, int maxQnty, int qntyToOrder, int returnedProduct) {
		instance = new Consommation(qntPremJour, qntRecuMens, qntConsomMens, qntRestMens, location, drugProduct, stockOut, adjustMonthlyConsumption, maxQnty, qntyToOrder, returnedProduct);
		return instance;
	}
	
	/**
	 * Clears the singleton instance
	 */
	public static void clearInstance() {
		instance = null;
	}
	
	public Drug getDrug() {
		return drug;
	}
	
	public Concept getConcept() {
		return concept;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public DrugProduct getDrugProduct() {
		return drugProduct;
	}
	public void setDrugProduct(DrugProduct drugProduct) {
		this.drugProduct = drugProduct;
	}
	/**
	 * @return the drugName
	 */
	public String getDrugName() {
		return drugName;
	}
	/**
	 * @param drugName the drugName to set
	 */
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}	
	/**
	 * @return the drugId
	 */
	public String getDrugId() {
		return drugId;
	}
	/**
	 * @param drugId the drugId to set
	 */
	public void setDrugId(String drugId) {
		this.drugId = drugId;
	}	
	/**
	 * @return the conceptId
	 */
	public String getConceptId() {
		return conceptId;
	}
	/**
	 * @param conceptId the conceptId to set
	 */
	public void setConceptId(String conceptId) {
		this.conceptId = conceptId;
	}
	/**
	 * @return the forme
	 */
	public String getForme() {
		return forme;
	}
	/**
	 * @param forme the forme to set
	 */
	public void setForme(String forme) {
		this.forme = forme;
	}
	/**
	 * @return the conditUnitaire
	 */
	public String getConditUnitaire() {
		return conditUnitaire;
	}
	/**
	 * @param conditUnitaire the conditUnitaire to set
	 */
	public void setConditUnitaire(String conditUnitaire) {
		this.conditUnitaire = conditUnitaire;
	}
	/**
	 * @return the qntPremJour
	 */
	public int getQntPremJour() {
		return qntPremJour;
	}
	/**
	 * @param qntPremJour the qntPremJour to set
	 */
	public void setQntPremJour(int qntPremJour) {
		this.qntPremJour = qntPremJour;
	}
	/**
	 * @return the qntRecuMens
	 */
	public Object getQntRecuMens() {
		return qntRecuMens;
	}
	/**
	 * @param obQntyRestMens the qntRecuMens to set
	 */
	public void setQntRecuMens(Object obQntyRestMens) {
		this.qntRecuMens = obQntyRestMens;
	}
	/**
	 * @return the qntConsomMens
	 */
	public Object getQntConsomMens() {
		return qntConsomMens;
	}
	/**
	 * @param obQntyConsomMens the qntConsomMens to set
	 */
	public void setQntConsomMens(Object obQntyConsomMens) {
		this.qntConsomMens = obQntyConsomMens;
	}
	/**
	 * @return the qntRestMens
	 */
	public int getQntRestMens() {
		return qntRestMens;
	}
	/**
	 * @param qntRestMens the qntRestMens to set
	 */
	public void setQntRestMens(int qntRestMens) {
		this.qntRestMens = qntRestMens;
	}
	/**
	 * @return the locationId
	 */
	public int getLocationId() {
		return locationId;
	}
	/**
	 * @param locationId the locationId to set
	 */
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	/**
	 * @param expirationDate the expirationDate to set
	 */
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	/**
	 * @return the expirationDate
	 */
	public Date getExpirationDate() {
		return expirationDate;
	}
	/**
	 * @return the stockOut
	 */
	public int getStockOut() {
		return stockOut;
	}
	/**
	 * @param stockOut the stockOut to set
	 */
	public void setStockOut(int stockOut) {
		this.stockOut = stockOut;
	}
	/**
	 * @return the adjustMonthlyConsumption
	 */
	public int getAdjustMonthlyConsumption() {
		return adjustMonthlyConsumption;
	}
	/**
	 * @param adjustMonthlyConsumption the adjustMonthlyConsumption to set
	 */
	public void setAdjustMonthlyConsumption(int adjustMonthlyConsumption) {
		this.adjustMonthlyConsumption = adjustMonthlyConsumption;
	}
	/**
	 * @return the maxQnty
	 */
	public int getMaxQnty() {
		return maxQnty;
	}
	/**
	 * @param maxQnty the maxQnty to set
	 */
	public void setMaxQnty(int maxQnty) {
		this.maxQnty = maxQnty;
	}
	/**
	 * @return the qntyToOrder
	 */
	public int getQntyToOrder() {
		return qntyToOrder;
	}
	/**
	 * @param qntyToOrder the qntyToOrder to set
	 */
	public void setQntyToOrder(int qntyToOrder) {
		this.qntyToOrder = qntyToOrder;
	}
	/**
	 * @return the returnedProduct
	 */
	public int getReturnedProduct() {
		return returnedProduct;
	}
	/**
	 * @param returnedProduct the returnedProduct to set
	 */
	public void setReturnedProduct(int returnedProduct) {
		this.returnedProduct = returnedProduct;
	}
	/**
	 * @return the adjustedProduct
	 */
	public int getAdjustedProduct() {
		return adjustedProduct;
	}
	/**
	 * @param adjustedProduct the adjustedProduct to set
	 */
	public void setAdjustedProduct(int adjustedProduct) {
		this.adjustedProduct = adjustedProduct;
	}
}
