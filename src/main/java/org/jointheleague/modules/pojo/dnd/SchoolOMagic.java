package org.jointheleague.modules.pojo.dnd;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SchoolOMagic {
@SerializedName("name")
@Expose
private String name;

public String getName() {
	return name;
}
}
