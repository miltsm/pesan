package my.mildotdev.pesan

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform