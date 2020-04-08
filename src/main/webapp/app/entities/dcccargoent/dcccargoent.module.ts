import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JhipsterSampleTCuSharedModule } from 'app/shared/shared.module';
import { DCCCARGOENTComponent } from './dcccargoent.component';
import { DCCCARGOENTDetailComponent } from './dcccargoent-detail.component';
import { DCCCARGOENTUpdateComponent } from './dcccargoent-update.component';
import { DCCCARGOENTDeleteDialogComponent } from './dcccargoent-delete-dialog.component';
import { dCCCARGOENTRoute } from './dcccargoent.route';

@NgModule({
  imports: [JhipsterSampleTCuSharedModule, RouterModule.forChild(dCCCARGOENTRoute)],
  declarations: [DCCCARGOENTComponent, DCCCARGOENTDetailComponent, DCCCARGOENTUpdateComponent, DCCCARGOENTDeleteDialogComponent],
  entryComponents: [DCCCARGOENTDeleteDialogComponent]
})
export class JhipsterSampleTCuDCCCARGOENTModule {}
