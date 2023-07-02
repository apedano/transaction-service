package transactionservice.resource;


import banking.api.service.AccountService;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.math.BigDecimal;

@Path("/api/transactions")
public class TransactionResource {
    @Inject
    @RestClient //CDI qualifier telling Quarkus to inject a type-safe REST client bean matching the interface
    private AccountService accountService;

    @POST
    @Path("/{acctNumber}")
    public Response newTransaction(@PathParam("acctNumber") Long accountNumber,
                                   BigDecimal amount) {
        accountService.transact(accountNumber, amount);
        return Response.ok().build();
    }
}
