# Dita-OT

## introduction 

- It is recommended to have a single topic per XML file .(建議每個XML文件都有一個topic)
- It is recommended filename extension for a topic file is ".dita".（topic 的格式=「.dita」)
- The recommended filename extension for a map file is ".ditamap". （ditamap 的格式 = 「.ditamap」
- Topic and map files may be contained in different directories. You are free to organize the contents of these directories as you wish. (topic 跟 map 可儲存在不同的路徑，您可以自由在map組織裡面的內容（topic））


## dita topic

- contains:
  - <title> element
  - An optional <shortdesc> Opens in new window or <abstract> Opens in new window element.
  - <body> element
  - optional <related-links> element
  
## most used block elements

- paragraph is represented by \<p\> tag.
- preformatted paragraph is represented by \<pre\> element
- itemized list is represented by \<ul\> and it contains \<li\> elements.
- ordered list is represented by \<ol\> element.
- A variable list is represented by the \<dl\> element. Unlike HTML's \<dl\>, the \<dt\> Opens in new window (term being defined) and the \<dd\> Opens in new window (term definition) elements must be wrapped in a <dlentry> Opens in new window element.

### Example:

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



## ditamaps
## problems
