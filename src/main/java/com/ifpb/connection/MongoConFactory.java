package com.ifpb.connection;

import com.mongodb.MongoClient;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class MongoConFactory {
    CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient
                    .getDefaultCodecRegistry(),
            fromProviders(PojoCodecProvider.builder().automatic(true).build()));

    MongoClient client = new MongoClient();

    //Criação do banco
//    MongoDatabase database = client.getDatabase("")
//            .withCodecRegistry(pojoCodecRegistry);
}
