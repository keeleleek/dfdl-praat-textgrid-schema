# DFDL parser/unparser for Praat TextGrid and XML

This is a first try on a  [Data Format Description Language (DFDL)](http://dfdlschemas.github.io/) parser and unparser for [Praat](http://www.fon.hum.uva.nl/praat/) TextGrid files. The DFDL schema enables to read and modify TextGrid files using XML technology. This makes possible lossless archiving of original TextGrid files alongside a XML database. XML technology can be used to create interfaces and adapters between different data formats.

The XML schema is not definite yet. Any comments welcome.

## XML structure of Praat TextGrid files

The current logical structure of the XML schema of TextGrid files is pictured below. The schema is not definite yet. The structure is meant to be simple and descriptive and map one-to-one to the textual format of TextGrid files.

```xml
<praat>
  <fileType>ooTextFile</fileType>
  <objectClass>TextGrid</objectClass>
  <xMin>0</xMin>
  <xMax>2</xMax>
  <tiersExists>exists</tiersExists>
  <numberOfTiers>10</numberOfTiers>
  <items>
    <item>
      <itemNum>1</itemNum>
      <class>IntervalTier</class>
      <name>word</name>
      <xMin>0</xMin>
      <xMax>2</xMax>
      <intervalsSize>8</intervalsSize>
      <intervals>
        <interval>
          <intervalNum>1</intervalNum>
          <xMin>0</xMin>
          <xMax>0.061199346418562</xMax>
          <text>noh</text>
        </interval>
        <!-- snip! -->
      </intervals>
    </item>
    <!-- snip! -->
    <item>
      <itemNum>10</itemNum>
      <class>IntervalTier</class>
      <name>other</name>
      <xMin>0</xMin>
      <xMax>2</xMax>
      <intervalsSize>1</intervalsSize>
      <intervals>
        <interval>
          <intervalNum>1</intervalNum>
          <xMin>0</xMin>
          <xMax>2</xMax>
          <text />
        </interval>
      </intervals>
    </item>
  </items>
</praat>
```

The example data originates from the [Phonetic Corpus of Estonian Spontaneous Speech](http://www.keel.ut.ee/en/languages-resourceslanguages-resources/phonetic-corpus-estonian-spontaneous-speech) (direct link to the [search engine](http://www.murre.ut.ee/otsing/ekskfk.php?select%5B0%5D%5Blayer%5D=word&select%5B0%5D%5Blogic%5D=REGEXP&select%5B0%5D%5Btext%5D=miski&korpused%5B0%5D=dialoogid&korpused%5B1%5D=monoloogid&limit=50&submit=Otsi)).

## How to parse/unparse TextGrid to XML

The DFDL schema has been developed and tested using the open source tool [Daffodil](https://opensource.ncsa.illinois.edu/confluence/display/DFDL).

Parsing the example TextGrid file.
```shell
$ ../bin/daffodil parse --schema ./PraatTextGrid.dfdl.xsd ./examples/ekskfk_miski_1.TextGrid
```

Un-parsing the parsed example XML infoset back to TextGrid text file.

```shell
$ ../bin/daffodil unparse --schema ./PraatTextGrid.dfdl.xsd ./examples/ekskfk_miski_1.tdml
```
