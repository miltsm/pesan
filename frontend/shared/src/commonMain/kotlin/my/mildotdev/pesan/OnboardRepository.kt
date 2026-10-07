package my.mildotdev.pesan

import auth.v1.OnboardService
import auth.v1.PasswordOnboardRequest
import auth.v1.invoke
import kotlinx.rpc.grpc.client.GrpcClient
import kotlinx.rpc.withService

class OnboardRepository() {

    // TODO: inject via hilt for android, default new instance if ios
    private val client = GrpcClient("localhost", 8080) {
        plaintext()
    }
    private val service = client.withService<OnboardService>()

    // TODO: complete this grpc call to onboard new user
    suspend fun createViaPassword(newHandle: String) {
        val response = service.passwordOnboard(PasswordOnboardRequest {
            userHandle = newHandle
        })
    }
}