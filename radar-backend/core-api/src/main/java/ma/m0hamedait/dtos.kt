package ma.m0hamedait

import java.util.Date

// Owner
data class ownerDto(
    var id: String,
    var name: String,
    var birthday: Date,
    var email: String,
    var phone: String,
)

data class CreateOwnerRequestDTO(
    var id: String,
    var name: String,
    var birthday: Date,
    var email: String,
    var phone: String,
)

data class UpdateOwnerRequestDTO(
    var id: String,
    var name: String,
    var birthday: Date,
    var email: String,
    var phone: String,
)

// vehicle
data class vehicleDto(
    var id: String,
    var matricule: String,
    var brand: String,
    var model: String,
    var color: String,
    var fiscalPower: Int,
    var ownerId: String,
)

data class CreateVehicleRequestDTO(
    var id: String,
    var matricule: String,
    var brand: String,
    var model: String,
    var color: String,
    var fiscalPower: Int,
    var ownerId: String
)

data class UpdateVehicleRequestDTO(
    var id: String,
    var matricule: String,
    var brand: String,
    var model: String,
    var color: String,
    var fiscalPower: Int,
)

data class deleteVehicleRequestDTO(
    var id: String,
)

data class changeVehiculeOwnerDTO(
    var id: String,
)


// radar
data class radarDto(
    var id: String="",
    var longitude: String="",
    var latitude: String="",
    var speedLimit: Int=0
)

data class CreateRadarRequestDTO(
    var longitude: String="",
    var latitude: String="",
    var speedLimit: Int=0
)

data class UpdateRadarRequestDTO(
        var id: String="",
    var longitude: String="",
    var latitude: String="",
    var speedLimit: Int=0
)

//infraction
data class infractionDto(
        var date: Date,
        var radarId: String,
        var vehicleMatricule: String,
        var vehicleSpeed: Int,
        var amountToPay: Double,
)

data class CreateInfractionRequestDTO(
        var radarId: String,
        var vehicleMatricule: String,
        var vehicleSpeed: Int,
        var speedLimit: Int,
        var amountToPay: Double,
)

data class UpdateInfractionRequestDTO(
        var id:String,
        var date: Date,
        var radarId: String,
        var vehicleMatricule: String,
        var vehicleSpeed: Int,
        var amountToPay: Double,
        var isPaid: Boolean,
)