package sk.fri.uniza.resources;

import io.dropwizard.hibernate.UnitOfWork;
import io.swagger.annotations.*;
import sk.fri.uniza.api.FilterEnum;
import sk.fri.uniza.core.DateTimeFormat;
import sk.fri.uniza.db.DataDAO;
import sk.fri.uniza.db.HouseHoldDAO;
import sk.fri.uniza.model.AbstractData;
import sk.fri.uniza.model.HouseHold;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDateTime;
import java.util.List;

// Určené na konfigurovanie swagger dokumentačného nástroja
@SwaggerDefinition(
        info = @Info(
                description = "HouseHold data",
                version = "V1.0.0",
                title = "HouseHold service",
                contact = @Contact(
                        name = "Martin Húdik",
                        email = "martin.hudik@fri.uniza.sk"
                )
        ),
        consumes = {"application/json"},
        produces = {"application/json"},
        schemes = {SwaggerDefinition.Scheme.HTTP}

)
@Api("/household") // Swagger
@Path("/household") // JAX-RS
@Produces(MediaType.APPLICATION_JSON)//Výstupné dáta sú vo forme JSON //JAX-RS
@Consumes(MediaType.APPLICATION_JSON) //Vstupné dáta sú vo forme JSON //JAX-RS
public class HouseHoldResource {

    private HouseHoldDAO houseHoldDAO;
    private DataDAO dataDAO;

    public HouseHoldResource(HouseHoldDAO houseHoldDAO,
                             DataDAO dataDAO) {
        this.houseHoldDAO = houseHoldDAO;
        this.dataDAO = dataDAO;
    }


    public AbstractData addData(Long hhId,
                                String fieldID,
                                AbstractData data) {
        return null;
    }


    public List<AbstractData> getData(Long hhId,
                                      String fieldID,
                                      final LocalDateTime from,
                                      final LocalDateTime to) {
        return null;
    }

    @POST /*JAX-RS*/
    @UnitOfWork //Otvorí novú hibernate session // Dropwizard
    @ApiOperation(value = "Pridanie novej domácnosti")
    public HouseHold createHouseHold(@Valid HouseHold houshold) {
        return houseHoldDAO.create(houshold);
    }

    @PUT /*JAX-RS*/
    @Path("{id}") /*JAX-RS*/
    @UnitOfWork //Otvorí novú hibernate session // Dropwizard
    @ApiOperation(value = "Úprava existujúcej domácnosti")
    public HouseHold updateHouseHold(
            @ApiParam(value = "ID", required = true) @PathParam("id") Long id,
            @Valid HouseHold houshold) {
        houshold.setId(id);
        return houseHoldDAO.update(houshold);
    }


    public List<HouseHold> listHouseHold() {
        return null;
    }

    @GET
    @Path("{id}")
    @UnitOfWork //Otvorí novú hibernate session
    @ApiOperation(value = "Údaje o konkrétnej domácnosť")
    public HouseHold getHouseHold(
            @ApiParam(value = "ID", required = true) @PathParam("id") Long id) {
        return houseHoldDAO.findById(id);
    }


    public List<HouseHold> filterHouseHold(
            FilterEnum filter,
            String value) {

        return null;
    }

}
