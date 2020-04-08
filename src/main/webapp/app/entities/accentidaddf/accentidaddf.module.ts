import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JhipsterSampleTCuSharedModule } from 'app/shared/shared.module';
import { ACCENTIDADDFComponent } from './accentidaddf.component';
import { ACCENTIDADDFDetailComponent } from './accentidaddf-detail.component';
import { ACCENTIDADDFUpdateComponent } from './accentidaddf-update.component';
import { ACCENTIDADDFDeleteDialogComponent } from './accentidaddf-delete-dialog.component';
import { aCCENTIDADDFRoute } from './accentidaddf.route';

@NgModule({
  imports: [JhipsterSampleTCuSharedModule, RouterModule.forChild(aCCENTIDADDFRoute)],
  declarations: [ACCENTIDADDFComponent, ACCENTIDADDFDetailComponent, ACCENTIDADDFUpdateComponent, ACCENTIDADDFDeleteDialogComponent],
  entryComponents: [ACCENTIDADDFDeleteDialogComponent]
})
export class JhipsterSampleTCuACCENTIDADDFModule {}
