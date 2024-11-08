## References
- https://github.com/ClickHouse/ClickHouse/tree/master/utils/antlr

## This parser is unsupported

We keep it in this repository for your curiosity. But this is not the parser of ClickHouse.

## How to generate source code files from grammar

Grammar is located inside `ClickHouseLexer.g4` and `ClickHouseParser.g4` files.

To generate source code you need to install locally the `antlr4` binary:
```
cd src/Parsers/New
antlr4 -no-listener -visitor -package DB -Dlanguage=Cpp ClickHouseLexer.g4  # if you have changes in a lexer part of grammar
antlr4 -no-listener -visitor -package DB -Dlanguage=Cpp ClickHouseParser.g4
```

Commit only git-tracked generated files - not all of the generated content is required.
