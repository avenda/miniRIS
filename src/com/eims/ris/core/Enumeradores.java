package com.eims.ris.core;

public class Enumeradores{
	/*public class DateTimeFormat{
		public String FormatDate = "dd-MM-yyyy";
		public String FormatTime = "HH:mm:ss";
		public String FormatDateTime = "dd-MM-yyyy HH:mm:dd";
	}*/
	public enum Action{
		None,
		New,
		Edit,
		Delete,
		Search
	}
	public enum Message{
		Information,
		Question,
		Error
	}
	public enum DateTimeFormat{
		Date,
		Time,
		DateTime
	}
	public enum Dia{
		Lunes,
		Martes,
		Miercoles,
		Jueves,
		Viernes,
		Sabado,
		Domingo
	}
}
