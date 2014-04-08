package com.semantics3.api;

import java.io.IOException;

import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

import org.json.JSONException;
import org.json.JSONObject;

public class Offers extends Semantics3Request {

	public Offers(String apiKey, String apiSecret) {
		super(apiKey, apiSecret, "offers");
	}

	public Offers field(Object... fields) throws JSONException {
		super.field(fields);
		return this;
	}

	public JSONObject getOffers() throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, IOException, JSONException {
		return this.get();
	}

	public Offers offersField(Object... fields) throws JSONException {
		return this.field(fields);
	}

}
