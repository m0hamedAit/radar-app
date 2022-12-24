package ma.m0hamedait

import org.axonframework.modelling.command.TargetAggregateIdentifier
import org.checkerframework.checker.units.qual.Speed
import java.util.*

abstract class BaseEvent<T>(
        @TargetAggregateIdentifier open val id: T
);

//radar
data class RadarCreatedEvent(
        override var id: String,
        var latitude: String,
        var longitude: String,
        var speedLimit: Int
) : BaseEvent<String>(id);

data class RadarUpdatedEvent(
        override var id: String,
        var latitude: String,
        var longitude: String,
        var speedLimit: Int
) : BaseEvent<String>(id);

data class RadarDeletedEvent(
        override var id: String
) : BaseEvent<String>(id);


//Owner
data class OwnerCreatedEvent(
        override var id: String,
        var name: String,
        var birthday: Date,
        var email: String,
        var phone: String
) : BaseEvent<String>(id);

data class OwnerUpdatedEvent(
        override var id: String,
        var name: String,
        var birthday: Date,
        var email: String,
        var tel: String
) : BaseEvent<String>(id);

data class OwnerDeletedEvent(
        override var id: String
) : BaseEvent<String>(id);

//Vehicle
data class VehicleCreatedEvent(
        override var id: String,
        var matricule: String,
        var brand: String,
        var model: String,
        var color: String,
        var fiscalPower: Int,
        var ownerID: String
) : BaseEvent<String>(id);

data class VehicleUpdatedEvent(
        override var id: String,
        var matricule: String,
        var brand: String,
        var model: String,
        var color: String,
        var fiscalPower: Int,
) : BaseEvent<String>(id);

data class VehicleDeletedEvent(
        override var id: String
) : BaseEvent<String>(id);

data class VehicleOwnerChangedEvent(
        override var id: String,
        var ownerID: String
) : BaseEvent<String>(id);

//infraction
data class InfractionCreatedEvent(
        override var id: String,
        var date: Date,
        var radarID: String,
        var vehicleMatricule: String,
        var vehicleSpeed: Int,
        var radarSpeedLimit: Int,
        var amountToPay: Double,
        var isPaid: Boolean
) : BaseEvent<String>(id);

data class InfractionPaidEvent(
        override var id: String,
        var amountToPay: Double,
        var isPaid: Boolean
) : BaseEvent<String>(id);