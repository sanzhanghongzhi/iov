package com.zbmatsu.iov.common.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface EventLog {

	public abstract EventName eventName();  
	public abstract EventType eventType();
	
	
	
	public static enum EventName{
		VEHICLE, OPERATOR_FLEETS, FLEET_VEHICLES, FLEET, ENTERPRISE_VEHICLES,
		ENTERPRISE_DRIVERS, ENTERPRISE, DRIVER_VEHICLE_HISTORY,DRIVER,
		DRIVER_VEHICLE;
	}
	
	public static enum EventType{
		NEW, UPDATE, DELETE, CORRECT, CREATE, TERMINATE, REMOVE;
	}
}