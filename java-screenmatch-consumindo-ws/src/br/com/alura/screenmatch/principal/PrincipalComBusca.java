package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOMDB;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class PrincipalComBusca {

    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(
                URI.create("https://www.omdbapi.com/?t=matrix&apikey=b98e26bc")).build();

        HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
        TituloOMDB titulo = gson.fromJson((String) response.body(), TituloOMDB.class);
        System.out.println(titulo);
    }
}