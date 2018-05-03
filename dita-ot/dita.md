# Dita-OT Manual

## introduction 
- To summarize: **DITA是基於XML的資料架構，用於build，開發，管理和發佈。**
- It is recommended to have a single topic per XML file .(建議每個XML文件都有一個topic)
- It is recommended filename extension for a topic file is ".dita".（topic 的格式=「.dita」)
- The recommended filename extension for a map file is ".ditamap". （ditamap 的格式 = 「.ditamap」
- Topic and map files may be contained in different directories. You are free to organize the contents of these directories as you wish. (topic 跟 map 可儲存在不同的路徑，您可以自由在map組織裡面的內容（topic））

![dita architecture](https://github.com/weily10/projects/blob/master/dita-ot/images/Screen%20Shot%202018-05-02%20at%2018.11.01.png)

## how to create a project using oxygen XML (如何用oxgyen XML 新建個dita專案）

1. 在桌面的任何地方建個文件夾
2. 在資料夾裡面建個 XPR 檔（new project)，然後點兩下。
結構會像這樣：

3. 在oxygen：File -> New -> Framework Templates -> DITA -> Topic (選擇你要的DITA檔）
4. 在oxygen：File -> New -> Framework Templates -> DITAMAP -> Map (選擇你要的DITAMAP檔）



## dita topic

- contains:
  - <title> element (文件名稱）
  - An optional \<shortdesc\> or \<abstract\> element (描述).
  - \<body\> element （content都要寫在裡面）
  - optional \<related-links\> element (資料來源）
  
#### Example:
```html
<topic id="docbook_or_dita">
  <title>DITA or DocBook?</title>

  <shortdesc>Both DITA and DocBook are both mature, feature rich, document types,
  so which one to choose?</shortdesc>

  <body>
    <p>DocBook 5 is a mature document type. It is well-documented (DocBook:
    The Definitive Guide, DocBook XSL: The Complete Guide), featuring decent
    XSL stylesheets allowing conversion to a variety of formats, based on the
    best schema technologies: RELAX NG and Schematron.</p>

    <p>DITA concepts (topics, maps, specialization, etc) have an immediate
    appeal to the technical writer, making this document type more attractive
    than DocBook. However the DocBook vocabulary is comprehensive and very
    well thought out. So choose DITA if its technical vocabulary is
    sufficiently expressive for your needs or if, anyway, you intend to
    specialize DITA.</p>
  </body>

  <related-links>
    <link format="html" href="http://www.docbook.org/" scope="external">
      <linktext>DocBook 5</linktext>
    </link>

    <link format="html"
          href="http://www.oasis-open.org/committees/tc_home.php?wg_abbrev=dita"
          scope="external">
      <linktext>DITA</linktext>
    </link>
  </related-links>
</topic>
```

## most used block elements
### paragraph and list

- paragraph is represented by \<p\> tag (一段）.
- preformatted paragraph is represented by \<pre\> element(預先格式化的一段）.
- itemized list is represented by \<ul\> and it contains \<li\> elements.(無序list)
- ordered list is represented by \<ol\> element.(有序list)
- A variable list is represented by the \<dl\> element. Unlike HTML's \<dl\>, the \<dt\>(term being defined) and the \<dd\> (term definition) elements must be wrapped in a \<dlentry\>  element.(變量list)

#### Example:

```html
<ul>
  <li>First item.
    <p>Continuation paragraph.</p>
  </li>

  <li>Second item. This item contains an ordered list.
    <ol>
      <li>First do this.</li>
      <li>Then do that.</li>
      <li>Finally do this.</li>
    </ol>
  </li>

  <li>Third item. This item contains a variable list.
    <dl>
      <dlentry>
        <dt>Term #1</dt>
        <dd>Definition of term #1.</dd>
      </dlentry>

      <dlentry>
        <dt>Term #2</dt>
        <dd>Definition of term #2.</dd>
      </dlentry>
    </dl>
  </li>
</ul>
```
### sections
\<section\> element has always a \<title\> with it. (區塊）

#### Example:

```html
<section>
  <title>The customary “hello word” program in Tcl/Tk</title>

  <pre frame="all">button .hello -text "Hello, World!" -command { exit }
       pack .hello</pre>
</section>
```
## specialized topic types
The \<topic\> element is the most generic topic type. There are four more specialized topic types: \<concept\> Opens in new window, \<task\> Opens in new window, \<reference\> Opens in new window, \<glossentry\> Opens in new window. When appropriate, use a specialized topic type rather than a plain \<topic\>.
### \<concept\> element
- Create a \<concept\> element when you need to provide your reader with background information which must be absorbed in order to understand the rest of the document.（要寫重點的時候）

#### Example: 
```html
<concept id="what_is_a_cache">
  <title>What is a cache?</title>

  <shortdesc>Everything you'll ever need to know about
  <term>cache</term>s.</shortdesc>

  <conbody>
    <p>In computer science, a cache is a temporary storage area where
    frequently accessed data can be stored for rapid access.</p>
  </conbody>

  <related-links>
    <link format="html" href="http://en.wikipedia.org/wiki/Cache"
          scope="external">
      <linktext>Wikipedia definition of a cache</linktext>
    </link>
  </related-links>
</concept>
```
### \<task\> element

Create a \<task\> element when you need to explain step by step which procedure is to be followed in order to
accomplish a given task. （要寫一步步的流程）

#### Example:
```html
<task id="install_emacs">
 <title>Installing GNU Emacs</title>
 <taskbody>
 <prereq>Windows NT 4.0 or any subsequent version of Windows. 5Mb of free
 disk space.</prereq>
 <steps>
 <step>
 <cmd>Unzip the distribution anywhere.</cmd>
 <info>We recommend to use the free, open source, <xref format="html"
 href="http://www.info-zip.org/" scope="external">Info-ZIP</xref>
 utility to do so.</info>
 <stepxmp><screen>C:\&gt; unzip emacs-21.3-bin-i386.zip</screen></stepxmp>
 <stepresult><p>Doing this will create an
 <filepath>emacs-21.3</filepath> directory.</p></stepresult>
 </step>
 <step>
 <cmd>Go to the bin subdirectory.</cmd>
  <stepxmp><screen>C:\&gt; cd emacs-21.3\bin</screen></stepxmp>
 </step>
 <step>
 <cmd>Run <cmdname>addpm</cmdname>.</cmd>
 <stepxmp><screen>C:\emacs-21.3\bin&gt; addpm</screen></stepxmp>
 <stepresult>A confirmation dialog box is displayed.<fig>
 <image href="confirm_install_emacs.png"/>
 </fig></stepresult>
 </step>
 <step>
 <cmd>Click <uicontrol>OK</uicontrol> to confirm.</cmd>
 </step>
 </steps>
 </taskbody>
</task>
```

### \<reference\> element
Create a \<reference\> element when you need to add an entry to a reference manual. The \<reference\>
element is typically used to document a command or a function. （您需要在參考手冊中添加一個條目）

#### Example:

```html
<reference id="pwd_command">
 <title>The <cmdname>pwd</cmdname> command</title>
 <refbody>
 <refsyn><cmdname>pwd</cmdname></refsyn>
 <section><title>DESCRIPTION</title><p>Print the full filename of the
 current working directory.</p><note>Your shell may have its own version of
 <cmdname>pwd</cmdname>, which usually supersedes the version described
 here.</note></section>
 <section><title>AUTHOR</title><p>Written by John Doe. </p></section>
 </refbody>
 <related-links>
 <link format="html" href="http://www.manpagez.com/man/3/getcwd/"
 scope="external">
 <linktext><cmdname>getcwd</cmdname>(3)</linktext>
 </link>
 </related-links>
</reference>
```

### \<glossentry\> element
Create a \<glossentry\> element when you need to add entry to a glossary.（當你需要添加條目到詞彙表）

#### Example:

 ``` html
<glossgroup id="sample_glossary">
 <title>Sample glossary</title>
 <glossentry id="ajax">
 <glossterm>AJAX</glossterm>
 <glossdef><b>A</b>synchronous <b>Ja</b>vaScript and <b>X</b>ML. Web
 development techniques used on the client-side to create interactive web
 applications.</glossdef>
 </glossentry>
 <glossentry id="dhtml">
 <glossterm>DHTML</glossterm>
 <glossdef><b>D</b>ynamic <b>HTML</b>. Web development techniques used on
 the client-side to create interactive web sites.</glossdef>
 </glossentry>
 <glossentry id="javascript">
 <glossterm>JavaScript</glossterm>
 <glossdef>JavaScript is an object-oriented scripting language supported by
 all major web browsers. It allows the development of interactive web sites
 and web applications.</glossdef>
 <related-links>
 <link format="html" href="https://developer.mozilla.org/en/JavaScript"
 scope="external">
 <linktext>Mozilla's Official Documentation on JavaScript</linktext>
 </link>
 </related-links>
 </glossentry>
</glossgroup>
```

### Tables
- two kinds: \<simpletable\> for DITA and \<table\>(Docbook table).
- contains: optional \<sthead\> and \<strow\> elements. Both row elements, \<sthead\> and \<strow\>, contain \<stentry\> cell elements.
#### Example
```html
<table>
  <title>Sample CALS table</title>

  <tgroup cols="3">
    <colspec colwidth="1*"/>
    <colspec colwidth="2*"/>
    <colspec colwidth="3*"/>

    <thead>
      <row>
        <entry align="center">A</entry>
        <entry align="center">B</entry>
        <entry align="center">C</entry>
      </row>
    </thead>

    <tbody>
      <row>
        <entry>A,1</entry>
        <entry>B,1</entry>
        <entry>C,1</entry>
      </row>

      <row>
        <entry>A,2</entry>
        <entry>B,2</entry>
        <entry>C,2</entry>
      </row>
    </tbody>
  </tgroup>
</table>
```
## ditamaps
### \<map\> element:
- contain:
  - A \<title\> child element.
  - A \<topicmeta\> where you can specify the author of the document, the date of publication, etc. （您可以指定文檔的作者，發布日期，等等）
  - A hierarchy of \<topicref\> elements.（\<topicref\> elements的階層）
   
####  Example
 ```html
  <topicref href="topic.dita">
  <topicref href="topic_structure.dita">
    <topicref href="samples/sample_topic.dita"/>
  </topicref>
  <topicref href="block_elements.dita"/>
  <topicref href="inline_elements.dita"/>
  <topicref href="link_elements.dita"/>
</topicref>
```
#### the toc attribute

Specifying attribute toc="no" for a <topicref> element prevents it from appearing in the generated Table of Contents.（是否顯示在目錄） 
  
#### Example 
  
  ```html
  <topicref href="topic_structure.dita">
      <topicref href="samples/sample_topic.dita" toc="no"/>
    </topicref>
  ```
### the \<bookmap\> element

- A \<bookmap\> Opens in new window element is just a more elaborate form of \<map\> . We recommend using a \<bookmap\> for anything more complex than an article(編輯比文章更複雜在用）.
- contains: 
  * A \<booktitle\> element
  * A \<bookmeta\> element that contains richer information than \<topicmeta\>. （跟topicmeta一樣，但有更多資訊）
  * Specialization of \<topicref\>: \<part\> （部分）, \<chapter\>（章節） and \<appendix\> （附錄）. (分成比較詳細的tag）
- The hierarchy of references to topic elements which makes up the body of the document may be preceded by a \<frontmatter\> element and followed by a \<backmatter\> element.
- These wrapper elements can contain references to actual, hand-written, topics: bookabstract, \<preface\>, \<dedication\>, \<colophon\>, etc.
- However the most common use of \<frontmatter\> and \<backmatter\> is to contain the following, empty placeholder elements: \<toc\>, \<figurelist\> , \<tablelist\>, \<indexlist\> . These placeholders instructs the DITA processing software to automatically generate: a Table of Contents, a List of Figures, a List of Tables, an Index.（指定文件裡面的元素，可以用frontmatter，像是表格，圖片等等）

#### Example

```html
<bookmap>
  <booktitle>
    <mainbooktitle>DITA for the Impatient</mainbooktitle>
  </booktitle>

  <bookmeta>
    <authorinformation>
      <personinfo>...</personinfo>
      <organizationinfo>...</organizationinfo>
    </authorinformation>
    <critdates>
      <created date="October 7, 2009"/>
    </critdates>
  </bookmeta>

  <frontmatter>
    <booklists>
      <toc/>
      <figurelist/>
      <tablelist/>
    </booklists>
  </frontmatter>

  <chapter href="introduction.dita"/>
  <chapter href="topics_and_maps.dita"/>
  <chapter href="topic.dita">
    <topicref href="topic_structure.dita">
      <topicref href="samples/sample_topic.dita" toc="no"/>
    </topicref>
    <topicref href="block_elements.dita"/>
    <topicref href="inline_elements.dita"/>
    <topicref href="link_elements.dita"/>
  </chapter>
  .
  .
  .
  <chapter navtitle="Topic maps">
    <topicref href="map.dita"/>
    <topicref href="bookmap.dita"/>
  </chapter>
  <chapter href="conclusion.dita"/>
</bookmap>
```
  

