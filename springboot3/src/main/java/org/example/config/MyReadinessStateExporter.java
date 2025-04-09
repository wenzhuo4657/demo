package org.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyReadinessStateExporter {

	private final ApplicationEventPublisher eventPublisher;

	public MyReadinessStateExporter(ApplicationEventPublisher eventPublisher) {
		this.eventPublisher = eventPublisher;
	}


	@EventListener
	public void onStateChange(AvailabilityChangeEvent<ReadinessState> event) {
		switch (event.getState()) {
			case ACCEPTING_TRAFFIC -> {
				// create file /tmp/healthy
				System.out.println("Accepting traffic");
			}
			case REFUSING_TRAFFIC -> {
				// remove file /tmp/healthy
				System.out.println("Refusing traffic");
			}
		}
	}


	@EventListener
	public  void onPo(po event){
		System.out.println(event.getSource());
	}

}