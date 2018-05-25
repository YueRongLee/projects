# 什麼是VUEX?

- 是用來管理狀態的，【狀態】在vuex 裡面是指你的程式裡面的data （變數，物件，陣列等等..）
- 一個小程式是不會用到狀態管理的，因為基本上data都會define在components裡面，但如果程式比較廣大，很多component跟properties 就比較難管理了。Vuex會劃定個中央地點來管理這些 data。

# 如何建個專案？

- 可以用 Vue CLI（請確認是3.0.0-beta.6以上）來建 
- 請在你的project的資料夾打：

```console
vue create your-project-name
```

- 會出現以下的資訊，選manually select features：

```console
Vue CLI v3.0.0-beta.6
? Please pick a preset:
  default (babel, eslint)
> Manually select features
```

- 選vuex 跟 router 

```
? Check the features needed for your project:
 ( ) TypeScript
 ( ) Progressive Web App (PWA) Support
 (*) Router
>(*) Vuex
 ( ) CSS Pre-processors
 ( ) Linter / Formatter
 ( ) Unit Testing
 ( ) E2E Testing
```
- 按enter 接下來會問config要儲存在哪 選*In dedicated config files* 就好了 ， 接下來選*n*如果你不要儲存目前的預置。

- 進入你的資料夾下指令讓專案跑

```
cd your-project-name && npm run serve
```

# The Vue Devtools Chrome Plugin
雖然不要求安裝，這個plugin能幫忙debug你的 vue app ， 能看到目前state的情況 是開發的好幫手。

# 指定個State Property
進入/src/store.js，基本上這就是VUEX，是我們用來指定data、mutation、action、getter 及其他的花哨的東西。我們先來看state的部分，state 就是儲存data的地方。接下來我們在state裡面set一個property，這個property能當作我們app的title。

```
state: {
    title: 'My Custom Title'
  },
```
 別忘了save，接下來進入/src/components/HelloWorld.vue，調整你的template。
 ```html
 <template>
  <div>
    <h1>{{title}}</h1>
  </div>
</template>
```
接著在script的區段調整：
```html
<script>
import { mapState } from 'vuex'

export default {
  name: 'HelloWorld',
  computed: mapState([
    'title'
  ]) 
}
</script>
```
- 首先我們得import 可以讓我們從VUEX存取state的幫手叫 mapState ，這樣才抓得到我們建的title。接下來加上computed 及呼叫*mapState* 及pass一個陣列，陣列裡加上state property 的名稱。
- 這個動作會帶給我們title裡的直，也可以在template區塊用interpolation指定*title*
# ![tool demonstrating state](https://github.com/weily10/projects/blob/master/vuex/images/Screen%20Shot%202018-05-25%20at%2011.16.27.png)

- Vue devtool 會讓你看目前你定義的state。
- 你也可以定義個物件：
 ```html
<template>
  <div>
    <h1>{{custom}}</h1> 改了這邊
  </div>
</template>

<script>
import { mapState } from 'vuex'

export default {
  name: 'HelloWorld',
  computed: mapState({
    custom: 'hehe' //改了這邊
  })
}
</script>
```
- 指定不同的名稱叫 *custom*
- 未來會有很多state property不只有mapState()，在這個情況下必須用 *object spread operator* ，基本上在mapState前面加三點就是了

```html
<script>
import { mapState } from 'vuex'

export default {
  name: 'HelloWorld',
  computed: {
      ...mapState([
      'custom'
    ]),
  }
}
</script>
```
回到*src/store.js* 在define個array當作state property

```html
 state: {
    custom: 'title',
    animals: [
      'dog',
      'cat',
      'bird'
    ]
  },
```
在template指定list：
```html
  <ul>
       <li v-for="animal in animals" v-bind:key="animal">
         {{ animal }}
       </li>
  </ul>
```
還有script區段：
```html
<script>
import { mapState } from 'vuex'

export default {
  name: 'HelloWorld',
  computed: {
      ...mapState([
      'custom',
      'animals'
    ]),
  }
}
</script>
```
# ![tool demonstrating state 2](https://github.com/weily10/projects/blob/master/vuex/images/Screen%20Shot%202018-05-25%20at%2015.28.32.png)

done
