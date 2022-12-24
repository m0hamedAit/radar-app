package ma.m0hamedait

import org.axonframework.modelling.command.TargetAggregateIdentifier
import java.util.Date

abstract class BaseCommand<T>(
        @TargetAggregateIdentifier open val id: T
);

//Owner
data class CreateOwnerCommand(
        override val id: String,
        val name: String,
        val birthday: Date,
        val email: String,
        val phone: String
) : BaseCommand<String>(id);

data class UpdateOwnerCommand(
        override val id: String,
        val name: String,
        val birthday: Date,
        val email: String,
        val tel: String
) : BaseCommand<String>(id);

data class DeleteOwnerCommand(
        override val id: String
) : BaseCommand<String>(id);

data class AffectVehicleToOwnerCommand(
        override val id: String,
        val vehicle: String
) : BaseCommand<String>(id);

//Vehicle
data class CreateVehicleCommand(
        override val id: String,
        val matricule: String,
        val brand: String,
        val model: String,
        val color: String,
        val fiscalPower: Int,
        val ownerID: String
) : BaseCommand<String>(id);

data class UpdateVehicleCommand(
        override val id: String,
        val matricule: String,
        val brand: String,
        val model: String,
        val color: String,
        val fiscalPower: Int,
) : BaseCommand<String>(id);

data class DeleteVehicleCommand(
        override val id: String
) : BaseCommand<String>(id);

data class ChangeVehiculeOwnerCommand(
        override val id: String,
        val ownerId: String
) : BaseCommand<String>(id);

//radar
data class CreateRadarCommand(
        override val id: String,
        val longitude: String,
        val latitude: String,
        val speedLimit: Int
) : BaseCommand<String>(id);

data class UpdateRadarCommand(
        override val id: String,
        val longitude: String,
        val latitude: String,
        val speedLimit: Int
) : BaseCommand<String>(id);

data class DeleteRadarCommand(
        override val id: String
) : BaseCommand<String>(id);

//infraction
data class CreateInfractionCommand(
        override val id: String,
        val date: Date,
        val radarId: String,
        val vehicleMatricule: String,
        val vehicleSpeed: Int,
        val amountToPay: Double,
) : BaseCommand<String>(id);

data class UpdateInfractionCommand(
        override val id: String,
        val date: Date,
        val radarId: String,
        val vehicleMatricule: String,
        val vehicleSpeed: Int,
        val amountToPay: Double,
        val paid: Boolean
) : BaseCommand<String>(id);

data class DeleteInfractionCommand(
        override val id: String
) : BaseCommand<String>(id);
