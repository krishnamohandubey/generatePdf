package com.generatepdf.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class DataRequest {
	private String name;
	private String email;
	private String mobile;
	private String address;
}
