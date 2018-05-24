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
雖然不要求要安裝 這個plugin能幫你debug你的 vue app ， 能看到你目前state的情況。
