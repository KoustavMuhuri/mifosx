package org.mifosplatform.portfolio.savings.handler;

import org.mifosplatform.commands.annotation.CommandType;
import org.mifosplatform.commands.handler.NewCommandSourceHandler;
import org.mifosplatform.infrastructure.core.api.JsonCommand;
import org.mifosplatform.infrastructure.core.data.CommandProcessingResult;
import org.mifosplatform.portfolio.savings.service.SavingsApplicationProcessWritePlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@CommandType(entity = "CREATEORACTIVATESAVINGSACCOUNT", action = "CREATE")
public class CreateOrActivateSavingsAccountCommandHandler implements NewCommandSourceHandler {

    private final SavingsApplicationProcessWritePlatformService writePlatformService;

    @Autowired
    public CreateOrActivateSavingsAccountCommandHandler(final SavingsApplicationProcessWritePlatformService writePlatformService) {
        this.writePlatformService = writePlatformService;
    }

    @Transactional
    @Override
    public CommandProcessingResult processCommand(final JsonCommand command) {
        return this.writePlatformService.createOrActivateSavingsApplication(command);
    }

}