import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'accentidaddf',
        loadChildren: () => import('./accentidaddf/accentidaddf.module').then(m => m.JhipsterSampleTCuACCENTIDADDFModule)
      },
      {
        path: 'accentidaddvt',
        loadChildren: () => import('./accentidaddvt/accentidaddvt.module').then(m => m.JhipsterSampleTCuACCENTIDADDVTModule)
      },
      {
        path: 'accentidadper',
        loadChildren: () => import('./accentidadper/accentidadper.module').then(m => m.JhipsterSampleTCuACCENTIDADPERModule)
      },
      {
        path: 'dcccargoent',
        loadChildren: () => import('./dcccargoent/dcccargoent.module').then(m => m.JhipsterSampleTCuDCCCARGOENTModule)
      }
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ])
  ]
})
export class JhipsterSampleTCuEntityModule {}
