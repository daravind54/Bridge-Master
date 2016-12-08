package com.gmu.sockets;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

public abstract class AbstractUtility 
{
	public static JsonObject mergeProfileSummary(JsonObject oldJsonObject, JsonObject newJsonObject) {
        final JsonObjectBuilder jsonObjectBuilder =Json.createObjectBuilder();
 
        for (final String key : oldJsonObject.keySet()){
            jsonObjectBuilder.add(key, oldJsonObject.get(key));
        }
        for (final String key : newJsonObject.keySet()){
            jsonObjectBuilder.add(key, newJsonObject.get(key));
        }
 
        return jsonObjectBuilder.build();
    }
}
