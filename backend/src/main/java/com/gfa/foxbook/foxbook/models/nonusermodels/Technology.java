package com.gfa.foxbook.foxbook.models.nonusermodels;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "technologies")
public class Technology {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    public Technology(String technologyName) {
        this.name = technologyName;
    }

    public static List<Technology> getTechnologyList() {
        return List.of(
                new Technology("Java"),
                new Technology("Angular"),
                new Technology("Python"),
                new Technology("React"),
                new Technology("Node.js"),
                new Technology("Ruby"),
                new Technology("C++"),
                new Technology("HTML"),
                new Technology("CSS"),
                new Technology("JavaScript"),
                new Technology("TypeScript"),
                new Technology("SQL"),
                new Technology("NoSQL"),
                new Technology("MongoDB"),
                new Technology("Spring"),
                new Technology("Hibernate"),
                new Technology("JPA"),
                new Technology("Docker"),
                new Technology("Kubernetes"),
                new Technology("AWS"),
                new Technology("Azure"),
                new Technology("GCP"),
                new Technology("Linux"),
                new Technology("Windows"),
                new Technology("MacOS"),
                new Technology("iOS"),
                new Technology("Android"),
                new Technology("Flutter"),
                new Technology("Kotlin"),
                new Technology("Swift"),
                new Technology("C#"),
                new Technology("C"),
                new Technology("Go"),
                new Technology("Rust"),
                new Technology("PHP"),
                new Technology("Perl"),
                new Technology("Scala"),
                new Technology("Clojure"),
                new Technology("Elixir"),
                new Technology("Haskell"),
                new Technology("R"),
                new Technology("Julia"),
                new Technology("Assembly"),
                new Technology("Objective-C"),
                new Technology("F#"),
                new Technology("Dart"),
                new Technology("Lua"),
                new Technology("Bash"),
                new Technology("PowerShell"),
                new Technology("MATLAB"),
                new Technology("COBOL"),
                new Technology("Fortran"),
                new Technology("Lisp"),
                new Technology("Pascal"),
                new Technology("Ada"),
                new Technology("Scheme"),
                new Technology("Prolog"),
                new Technology("Smalltalk"),
                new Technology("Logo"),
                new Technology("RPG"),
                new Technology("PL/I"),
                new Technology("APL"),
                new Technology("Forth"),
                new Technology("Erlang"),
                new Technology("Tcl"),
                new Technology("Awk"),
                new Technology("Visual Basic"),
                new Technology("LabVIEW"),
                new Technology("ABAP"),
                new Technology("Delphi")
        );
    }
}
