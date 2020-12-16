const VERSION = "v1"

self.addEventListener('install', event =>{
    event.waitUntil(precache())
})

self.addEventListener('fetch', event =>{
    const peticion = event.request;
    if(peticion.method !== "GET"){
        return;
    }
    console.log('ay mae mia q si es getz')
    // Buscamos en el caché
    event.respondWith(cachedResponse(peticion))

    // Actualixamos el cache
    event.waitUntil(updateCache(peticion))
})

async function precache(){
    const cache = await caches.open(VERSION)
    return cache.addAll([
        './index.html',
        './assets/index.js',
        './assets/MediaPlayer.js',
        './assets/plugins/AutoPlay.js',
        './assets/plugins/AutoPause.js',
        '/assets/index.css',
        './assets/BigBuckBunny.mp4'
    ])
}

async function cachedResponse(request){
    const cache = await caches.open(VERSION);
    const response = await cache.match(request);
    return response || fetch(request);
}

async function updateCache(request){
    const cache = await caches.open(VERSION);
    const response = await fetch(request);
    return cache.put(request, response)
}