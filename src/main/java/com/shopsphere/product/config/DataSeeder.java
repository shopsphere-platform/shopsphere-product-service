package com.shopsphere.product.config;

import com.shopsphere.product.entity.Product;
import com.shopsphere.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.util.List;

@Component @RequiredArgsConstructor @Slf4j
public class DataSeeder implements CommandLineRunner {

    private final ProductRepository repo;

    @Override
    public void run(String... args) {
        if (repo.count() > 0) { log.info("Products already seeded"); return; }
        log.info("Seeding 8 watches...");

        repo.saveAll(List.of(
            Product.builder()
                .name("Helix Noir").collection("Noir Series")
                .tagline("Tourbillon · Perpetual Calendar")
                .description("The apex of horological engineering. A flying tourbillon at 6 o'clock compensates for gravitational error.")
                .price(new BigDecimal("48500")).category(Product.Category.MENS)
                .badge("Bestseller").movement("Manual-wind Tourbillon")
                .caseMaterial("Grade 5 Titanium").crystal("Sapphire anti-reflective")
                .waterResistance("100m").diameter("42mm").powerReserve("72 hours")
                .straps("Black Alligator,Black Rubber,Titanium Bracelet")
                .imageUrl("https://images.unsplash.com/photo-1523170335258-f5ed11844a49?w=600&q=80")
                .rating(4.9).reviewCount(84).isFeatured(true).build(),

            Product.builder()
                .name("Solaris Blanc").collection("Solar Series")
                .tagline("Chronograph · GMT")
                .description("A masterpiece in 18k white gold, the Solaris Blanc marries a high-frequency chronograph with a GMT complication.")
                .price(new BigDecimal("22800")).category(Product.Category.UNISEX)
                .badge("New").movement("Self-winding Chronograph")
                .caseMaterial("18k White Gold").crystal("Double-domed sapphire")
                .waterResistance("50m").diameter("39mm").powerReserve("68 hours")
                .straps("White Satin,Silver Bracelet")
                .imageUrl("https://images.unsplash.com/photo-1614164185128-e4ec99c436d7?w=600&q=80")
                .rating(4.8).reviewCount(127).isFeatured(true).build(),

            Product.builder()
                .name("Depth Master").collection("Aquanaut Series")
                .tagline("Diver · 500m")
                .description("Engineered for the deep, tested to 500 meters. Built for those who demand performance without compromise.")
                .price(new BigDecimal("15200")).category(Product.Category.MENS)
                .badge("Limited").movement("Automatic COSC-certified")
                .caseMaterial("PVD Steel").crystal("Sapphire with luminescent coating")
                .waterResistance("500m").diameter("44mm").powerReserve("70 hours")
                .straps("Blue Rubber,Steel Bracelet")
                .imageUrl("https://images.unsplash.com/photo-1594576722512-582bcd85b524?w=600&q=80")
                .rating(4.7).reviewCount(203).isFeatured(true).build(),

            Product.builder()
                .name("Empress Rose").collection("Empress Series")
                .tagline("Diamond Bezel · Moon Phase")
                .description("The Empress Rose is adorned with 96 VS-clarity diamonds set by hand on the bezel.")
                .price(new BigDecimal("38900")).category(Product.Category.WOMENS)
                .badge("Exclusive").movement("Self-winding moon phase")
                .caseMaterial("18k Rose Gold").crystal("Sapphire anti-reflective both sides")
                .waterResistance("30m").diameter("34mm").powerReserve("55 hours")
                .straps("Blush Alligator,Rose Gold Bracelet")
                .imageUrl("https://images.unsplash.com/photo-1612817288484-6f916006741a?w=600&q=80")
                .rating(5.0).reviewCount(41).isFeatured(true).build(),

            Product.builder()
                .name("Aether Grand").collection("Grand Complication")
                .tagline("Minute Repeater · Perpetual")
                .description("Among the most complex wristwatches ever produced. 847 individual components assembled by hand.")
                .price(new BigDecimal("125000")).category(Product.Category.MENS)
                .badge("Collector").movement("Hand-wound Grand Complication")
                .caseMaterial("Platinum 950").crystal("Flat sapphire")
                .waterResistance("30m").diameter("43mm").powerReserve("50 hours")
                .straps("Grey Alligator,Platinum Bracelet")
                .imageUrl("https://images.unsplash.com/photo-1522312346375-d1a52e2b99b3?w=600&q=80")
                .rating(5.0).reviewCount(12).isFeatured(false).build(),

            Product.builder()
                .name("Meridian GMT").collection("Meridian Series")
                .tagline("World Timer · 24 Cities")
                .description("Designed for those who conduct business across continents. Track 24 time zones simultaneously.")
                .price(new BigDecimal("18400")).category(Product.Category.UNISEX)
                .badge("New").movement("Self-winding World Timer")
                .caseMaterial("Stainless steel").crystal("Sapphire anti-reflective")
                .waterResistance("100m").diameter("40mm").powerReserve("65 hours")
                .straps("Navy Blue Alligator,Steel Bracelet")
                .imageUrl("https://images.unsplash.com/photo-1548171915-e79a380a2a4b?w=600&q=80")
                .rating(4.7).reviewCount(156).isFeatured(false).build(),

            Product.builder()
                .name("Veldt Chrono").collection("Adventure Series")
                .tagline("Flyback Chronograph")
                .description("Born from military specification, built to perform in the harshest conditions on earth.")
                .price(new BigDecimal("9800")).category(Product.Category.MENS)
                .badge(null).movement("Automatic flyback chronograph")
                .caseMaterial("DLC-coated steel").crystal("Hardened mineral glass")
                .waterResistance("200m").diameter("41mm").powerReserve("48 hours")
                .straps("Khaki Canvas,Brown Leather,Steel Bracelet")
                .imageUrl("https://images.unsplash.com/photo-1617043786394-f977fa12eddf?w=600&q=80")
                .rating(4.6).reviewCount(318).isFeatured(false).build(),

            Product.builder()
                .name("Zenith Pavé").collection("Zenith Series")
                .tagline("Full Pavé Diamond")
                .description("Every surface encrusted with brilliant-cut diamonds. The ultimate statement of luxury.")
                .price(new BigDecimal("67500")).category(Product.Category.WOMENS)
                .badge("Exclusive").movement("Swiss quartz ultra-thin")
                .caseMaterial("18k Yellow Gold").crystal("Sapphire")
                .waterResistance("30m").diameter("32mm").powerReserve("36 months battery")
                .straps("Diamond Bracelet")
                .imageUrl("https://images.unsplash.com/photo-1587836374828-4dbafa94cf0e?w=600&q=80")
                .rating(4.9).reviewCount(28).isFeatured(false).build()
        ));

        log.info("Seeded 8 watches successfully");
    }
}
