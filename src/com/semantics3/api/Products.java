package com.semantics3.api;

import java.io.IOException;

import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

import org.json.JSONException;
import org.json.JSONObject;

import com.semantics3.Util;

public class Products extends Semantics3Request {

	public Products(String apiKey, String apiSecret) {
		super(apiKey, apiSecret, "products");
		// TODO Auto-generated constructor stub
	}
	
	public JSONObject getProducts() throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, IOException, JSONException {
		return this.get();
	}
	public JSONObject getOffers() throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, IOException, JSONException {
		return this.get("offers");
	}
	public JSONObject getCategories() throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, IOException, JSONException {
		return this.get("categories");
	}
	
	public Products field(Object...fields) throws JSONException {
		super.field(fields);
		return this;
	}

	public Products productsField(Object... fields) throws JSONException {
		return this.field(fields);
	}
	public Products offersField(Object...fields) throws JSONException {
		this.add("offers", fields);
		return this;
	}
	public Products categoriesField(Object...fields) throws JSONException {
		this.add("categories", fields);
		return this;
	}
	
	public Products siteDetails(Object...fields) throws JSONException {
		this.field(Util.appendArray(fields, "sitedetails"));
		return this;
	}
	
	public Products latestOffers(Object...fields) throws JSONException {
		this.field(Util.appendArray(fields, "sitedetails","latestoffers"));
		return this;
	}
	
}
