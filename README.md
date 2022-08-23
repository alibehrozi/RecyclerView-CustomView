# Android RecyclerView template
An Android Studio templates for Android development.

Getting Started
---------------

##### Fetch code

```
git clone git clone https://github.com/alibehrozi/RecyclerView-CustomView.git
```

##### setup keystore
1. Copy your release.keystore into app/config
2. Fill out `RELEASE_KEY_PASSWORD`, `RELEASE_KEY_ALIAS`, `RELEASE_STORE_PASSWORD` in `gradle.properties` to access your  `release.keystore`

>**[gradle.properties](gradle.properties) :**
>```
>RELEASE_KEY_PASSWORD=YOUR_ANDROID_KEY
>RELEASE_KEY_ALIAS=YOUR_KEY_ALIAS
>RELEASE_STORE_PASSWORD=YOUR_PASSWORD
>```

##### Build project

4. Open the project in the Studio (note that it should be opened, NOT imported).
5. You are ready to compile project.

issue
------
##### ReDrawing EveryThing
Rather than updating the item, `notifyItemChanged(position)` calls `onDraw(Canvas c)` for every item in the `recyclerView`.
However, All other items will remain untouched if I call `invalidate()` to update my view.
Therefore, it is possible to update one item and not update the others.
Are we not wasting resources by doing this?

Support
-------

* **LinkedIn :** [https://www.linkedin.com/in/alibehrozi/](https://www.linkedin.com/in/alibehrozi/).