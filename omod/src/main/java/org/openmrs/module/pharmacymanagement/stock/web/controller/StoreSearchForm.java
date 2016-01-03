/**
 * Auto generated file comment
 */
package org.openmrs.module.pharmacymanagement.stock.web.controller;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.ConceptAnswer;
import org.openmrs.Drug;
import org.openmrs.api.ConceptService;
import org.openmrs.api.context.Context;
import org.openmrs.module.pharmacymanagement.DrugProductInventory;
import org.openmrs.module.pharmacymanagement.PharmacyConstants;
import org.openmrs.module.pharmacymanagement.StoreWarning;
import org.openmrs.module.pharmacymanagement.service.DrugOrderService;
import org.openmrs.util.OpenmrsConstants;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.ParameterizableViewController;

/**
 *
 */
public class StoreSearchForm extends ParameterizableViewController {
	private Log log = LogFactory.getLog(this.getClass());

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		DrugOrderService service = Context.getService(DrugOrderService.class);
		ConceptService conceptService = Context.getConceptService();
		Map itemMap = new HashMap<String, StoreWarning>();
		List<Drug> drugsInSystem = conceptService.getAllDrugs(); 
		List<DrugProductInventory> itemsInStore = service.getAllDrugProductInventory();
		Collection<ConceptAnswer> consumablesInSystem = conceptService.getConcept(PharmacyConstants.CONSUMABLE).getAnswers();
		String drugId = null, consumableId = null, name = "";
		int in = 0, out=0, solde=0;
		
		String locationStr = Context.getAuthenticatedUser().getUserProperties()
				.get(OpenmrsConstants.USER_PROPERTY_DEFAULT_LOCATION);
		
		
		StoreWarning storeWarning = null;
		if(request.getParameter("consumable") != null && !request.getParameter("consumable").equals("")) {
			if(request.getParameter("consumable").equals("0")) {
				for(DrugProductInventory dpi : itemsInStore) {
					if(dpi.getDrugproductId().getDrugId() != null) {
						drugId = dpi.getDrugproductId().getDrugId().getDrugId() + "";
						name = dpi.getDrugproductId().getDrugId().getName();
					}
					if(dpi.getDrugproductId().getConceptId() != null) {
						consumableId = dpi.getDrugproductId().getConceptId().getConceptId() + "";
						name = dpi.getDrugproductId().getConceptId().getName().getName();
					}
					String consStr = service.getSumEntreeSortieByFromToDrugLocation(null, new Date() + "", drugId, consumableId, locationStr)[1] + "";
					String inStr = service.getSumEntreeSortieByFromToDrugLocation(null, new Date() + "", drugId, consumableId, locationStr)[0] + "";

					out = consStr != null ? Integer.valueOf(consStr) : 0;
					in = inStr != null ? Integer.valueOf(inStr) : 0;
					solde = in - out;
					
					storeWarning = new StoreWarning();
					storeWarning.setConsumed(out);
					storeWarning.setIn(in);
					storeWarning.setLotNo(dpi.getDrugproductId().getLotNo());
					storeWarning.setExpirationDate(dpi.getDrugproductId().getExpiryDate() + "");
					storeWarning.setDrugName(drugId != null ? dpi.getDrugproductId().getDrugId().getName() : dpi.getDrugproductId().getConceptId().getName().getName());
					storeWarning.setStore(solde);
					
					itemMap.put(name, storeWarning);
					drugId = null;
					consumableId = null;
				}
			} else {						
				for(DrugProductInventory dpi : itemsInStore) {
					consumableId = request.getParameter("consumable");
					if(dpi.getDrugproductId().getConceptId() != null) {
						storeWarning = new StoreWarning();
						String outStr = service.getSumEntreeSortieByFromToDrugLocation(null, new Date() + "", null, consumableId, locationStr)[1] + "";
						String inStr = service.getSumEntreeSortieByFromToDrugLocation(null, new Date() + "", null, consumableId, locationStr)[0] + "";
						
						out = outStr != null ? Integer.valueOf(outStr) : 0;
						in = inStr != null ? Integer.valueOf(inStr) : 0;
						solde = in - out;
						
						storeWarning.setConsumed(out);
						storeWarning.setIn(in);
						storeWarning.setLotNo(dpi.getDrugproductId().getLotNo());
						storeWarning.setExpirationDate(dpi.getDrugproductId().getExpiryDate() + "");
						storeWarning.setDrugName(dpi.getDrugproductId().getConceptId().getName().getName());
						storeWarning.setStore(solde);
						
						itemMap.put(dpi.getDrugproductId().getConceptId().getName().getName(), storeWarning);
						break;
					}
				}
			}
		}
		
		if((request.getParameter("drug") != null && !request.getParameter("drug").equals(""))) {
			if(request.getParameter("drug").equals("0")) {
				for(DrugProductInventory dpi : itemsInStore) {
					if(dpi.getDrugproductId().getDrugId() != null) {
						drugId = dpi.getDrugproductId().getDrugId().getDrugId() + "";
						name = dpi.getDrugproductId().getDrugId().getName();
					}
					if(dpi.getDrugproductId().getConceptId() != null) {
						consumableId = dpi.getDrugproductId().getConceptId().getConceptId() + "";
						name = dpi.getDrugproductId().getConceptId().getName().getName();
					}
					storeWarning = new StoreWarning();
					in = Integer.valueOf(service.getSumEntreeSortieByFromToDrugLocation(null, new Date() + "", drugId, consumableId, locationStr)[0] + "");
					out = Integer.valueOf(service.getSumEntreeSortieByFromToDrugLocation(null, new Date() + "", drugId, consumableId, locationStr)[1] + "");
					solde = in - out;
					
					storeWarning.setConsumed(out);
					storeWarning.setIn(in);
					storeWarning.setLotNo(dpi.getDrugproductId().getLotNo());
					storeWarning.setExpirationDate(dpi.getDrugproductId().getExpiryDate() + "");
					storeWarning.setDrugName(dpi.getDrugproductId().getDrugId().getName());
					storeWarning.setStore(solde);
										
					itemMap.put(name, storeWarning);
				}
			} else {						
				for(DrugProductInventory dpi : itemsInStore) {
					drugId = request.getParameter("drug"); 
					if(dpi.getDrugproductId().getDrugId() != null) {
						if(dpi.getDrugproductId().getDrugId().getDrugId().equals(drugId)) {
							storeWarning = new StoreWarning();
							String inStr = service.getSumEntreeSortieByFromToDrugLocation(null, new Date() + "", drugId, null, locationStr)[0] + "";
							String outStr = service.getSumEntreeSortieByFromToDrugLocation(null, new Date() + "", drugId, null, locationStr)[1] + "";
							in = ((inStr != null) ? Integer.valueOf(inStr) : 0);
							out = ((outStr != null) ? Integer.valueOf(outStr) : 0);
							solde = in - out;
							
							storeWarning.setConsumed(out);
							storeWarning.setIn(in);
							storeWarning.setLotNo(dpi.getDrugproductId().getLotNo());
							storeWarning.setExpirationDate(dpi.getDrugproductId().getExpiryDate() + "");
							storeWarning.setDrugName(dpi.getDrugproductId().getDrugId().getName());
							storeWarning.setStore(solde);
							
							itemMap.put(dpi.getDrugproductId().getDrugId().getName(), storeWarning);
							break;
						}
					}
				}
			}
		}
		
		mav.addObject("itemMap", itemMap);
		mav.addObject("drugsInSystem", drugsInSystem);
		mav.addObject("consumablesInSystem", consumablesInSystem);

		mav.setViewName(getViewName());
		return mav;

	}
}