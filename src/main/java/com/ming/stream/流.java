package com.ming.stream;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 流 {
    public static void main(String[] args) {
        try {
            fileStream();
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private static void fileStream() throws IOException, URISyntaxException {
        String resource = 流.class.getResource("stream.txt").toURI().getPath();
        System.out.println(resource);
        final Path path =
                Paths.get(
                        resource.substring(1)
                );
        try( Stream< String > lines = Files.lines( path, StandardCharsets.UTF_8 ) ) {
            lines
                    .onClose( () -> System.out.println("Done!") )
                    .forEach( System.out::println );
        }

    }

    private void testJavaCollectionStream(){
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            list.add(String.valueOf(i));
        }
        list.stream().parallel().forEach(System.out::println);
        System.out.println(
                list.stream()
                        .mapToInt(Integer::parseInt)
//                    .reduce(11,Integer::sum)
//                        .sum()
                        .asLongStream()
                        .boxed()
                        .mapToLong(l -> l*100)
                        .mapToObj( l -> l+"%")
                        .collect(Collectors.toList())
        );
    }
}
