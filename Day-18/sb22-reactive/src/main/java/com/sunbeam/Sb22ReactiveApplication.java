package com.sunbeam;

import java.time.Duration;
import java.util.concurrent.Flow.Subscriber;
import java.util.stream.Stream;

import org.reactivestreams.Subscription;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class Sb22ReactiveApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Sb22ReactiveApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		demo1();  // java 8 stream
//		demo2();  // new CoreSubscriber {}
//		demo3();  // .subscribe(consumer)
//		demo4();  // .doOnNext()

//		demo5();  // Mono demo

//		demo6();  // .map() and .filter() demo
//		demo7();  // .log() method demo

//		demo8();  // Back-pressure demo

		// Operations
//		demo9();  //.count() method
//		demo10(); //.distinct() method
//		demo11(); //.defaultIfEmpty("...")
//		demo12(); //.switchIfEmpty(Flux)
//		demo13(); //.flatMap()
//		demo14(); //.delayElements() with .subscribe()
//		demo15(); //.delayElements() with .blockLast()
//		demo16(); //.delayElements() , .blockLast() , flatMap()
		demo17(); //.delayElements() , .blockLast() , concatMap()
	}

	private void demo17() {
		Flux<String> flux = Flux.just("Soham","Sakshi");
		Flux<String> resFlux = flux
								.concatMap( s -> Flux.just(s.split("")).delayElements(Duration.ofMillis(200)) )
								.doOnNext( s -> System.out.println(s));
		resFlux.blockLast();
	}

	private void demo16() {
		Flux<String> flux = Flux.just("Soham","Sakshi");
		Flux<String> resFlux = flux
								.flatMap( s -> Flux.just(s.split("")).delayElements(Duration.ofMillis(100)) )
								.doOnNext(s -> System.out.println(s));
		resFlux.blockLast();
	}
	private void demo15() {
		Flux<String> flux = Flux.just("Soham","Sakshi","Prisha","Sarthak","Madhura");
		Flux<String> resFlux = flux
								.delayElements(Duration.ofMillis(1000))
								.doOnNext(s -> System.out.println(s))
								.log();
		resFlux.blockLast(); // blocking operation
		// Subscribe to this Flux and block indefinitely until the upstream signals its first value or completes.
	}

	private void demo14() {
		Flux<String> flux = Flux.just("Soham","Sakshi","Prisha","Sarthak","Madhura");

		Flux<String> resFlux = flux
								.delayElements( Duration.ofMillis(1000))
								.doOnNext( s -> System.out.println(s))
								.log();
		resFlux.subscribe(); // non-blocking operation

	}

	private void demo13() {
		Flux<String> flux = Flux.just("Soham","Sakshi");
		Flux<String> resFlux =  flux
								.flatMap(s -> Flux.just( s.split("")));

		resFlux.subscribe(s -> System.out.println(s));
	}

	private void demo12() {
		Flux<String> flux = Flux.just("Soham","Sakshi","Prisha","Sarthak","Madhura");
		flux
			.filter( s -> s.contains("x"))
			.switchIfEmpty( Flux.just("Orange","Lemon","Apple") )
			.subscribe(s -> System.out.println(s));
	}

	private void demo11() {
		Flux<String> flux = Flux.just("Soham","Sakshi","Prisha","Sarthak","Madhura");
		flux
			.filter(s -> s.contains("x"))
			//.filter(s -> s.contains("i"))
			.defaultIfEmpty("unnamed")
			.subscribe( op -> System.out.println(op));
	}

	private void demo10() {
		Flux<String> flux = Flux.just("Soham","Sakshi","Prisha","Soham","Sakshi");
		flux
			.distinct() // removes the duplicate values
			.subscribe(s -> System.out.println(s));
	}

	private void demo9() {
		Flux<String> flux = Flux.just("Soham","Sakshi","Prisha","Sarthak","Madhura");
		Mono<Long> count = flux.count();
		count.subscribe( n -> System.out.println("count : "+n));
		flux.subscribe( n -> System.out.println(n));
	}

	private void demo8() {
		Flux<String> flux = Flux.just("Soham","Sakshi","Prisha","Sarthak","Madhura");

		CoreSubscriber<String> subscriber =
				new CoreSubscriber<String>() {

					private Subscription subscription;

					@Override
					public void onSubscribe(Subscription s) {
						this.subscription=s;

						System.out.println("onSubscribe() is called ..... ");
						//s.request(Long.MAX_VALUE); // unbounded request i.e. "all values" from publisher
						s.request(3); // Subscriber can Define the limit amount data it can consume
					}
					@Override
					public void onNext(String t) {
						System.out.println("onNext() is called :-  "+t);
						subscription.cancel(); // Subscriber can cancel the subscription at any time. Next elements will not be processed
					}
					@Override
					public void onComplete() {
						System.out.println("onComplete() is called ..... ");
					}
					@Override
					public void onError(Throwable t) {
						System.out.println("onError() is called ..... ");
					}
				};

		flux.subscribe(subscriber);
	}
	private void demo7() {
		Flux<String> flux = Flux
								.just("Soham","Sakshi","Prisha","Sarthak","Madhura")
								.log(); // Observe all reactive stream signals and trace them

		Flux<String> resFlux= flux.map( s -> s.toUpperCase());
		resFlux.subscribe( s -> System.out.println(s));
	}

	private void demo6() {
		Flux<String> flux = Flux.just("Soham","Sakshi","Prisha","Sarthak","Madhura");
		Flux<String> resutFlux = flux
									.map(s -> s.toUpperCase())
									.filter( s-> s.contains("I"));

		resutFlux.subscribe( s -> System.out.println(s));
	}

	private void demo5() {
		Mono<String> mono = Mono.just("Nilesh");
		mono.subscribe(s -> System.out.println(s));
	}

	private void demo4() {
		Flux<String> flux = Flux.just("Soham","Sakshi","Prisha","Sarthak","Madhura");

		//flux.doOnNext( s -> System.out.println(s));
		      // returns flux<> , but do not subscribe the flux , so no data processed

		flux
			.doOnNext( s -> System.out.println(s))
			.subscribe(); // Flux is subscribed , So Perform the Operations mentioned Earlier
	}

	private void demo3() {
		Flux<String> flux = Flux.just("Soham","Sakshi","Prisha","Sarthak","Madhura");
		flux.subscribe( s -> System.out.println(s)); //Consumer is executed for the Each item in the FLUX
	}

	private void demo2() {
		Flux<String> flux = Flux.just("Soham","Sakshi","Prisha","Sarthak","Madhura");

		CoreSubscriber<String> subscriber =
				new CoreSubscriber<String>() {

					@Override
					public void onSubscribe(Subscription s) {
						System.out.println("onSubscribe() is called ..... ");
						s.request(Long.MAX_VALUE);
					}
					@Override
					public void onNext(String t) {
						System.out.println("onNext() is called :-  "+t);
					}
					@Override
					public void onComplete() {
						System.out.println("onComplete() is called ..... ");
					}
					@Override
					public void onError(Throwable t) {
						System.out.println("onError() is called ..... ");
					}
				};

		flux.subscribe(subscriber);
	}

	private void demo1() {
		Stream<String> stream = Stream.of("ABC","XYZ","MNS");
		stream.forEach( str -> System.out.println(str));
	}
}
