# DFDL parser/unparser for Praat TextGrid

This is a first try on a [DFDL](http://dfdlschemas.github.io/) parser and unparser for [Praat](http://www.fon.hum.uva.nl/praat/) TextGrid files. The DFDL schema enables to read and modify TextGrid files using XML technology. This makes possible lossless archiving of original TextGrid files alongside a XML database. XML technology can be used to create interfaces and adapters between different data formats.

Any comments welcome.

## Example

Parsing the example TextGrid file.
```
$ ../bin/daffodil parse --schema ./PraatTextGrid.dfdl.xsd ./examples/ekskfk_miski_1.TextGrid
```

Un-parsing the parsed example XML infoset back to TextGrid text file.

```
$ ../bin/daffodil unparse --schema ./PraatTextGrid.dfdl.xsd ./examples/ekskfk_miski_1.tdml
```
