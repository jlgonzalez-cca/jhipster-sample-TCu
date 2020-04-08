import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { JhipsterSampleTCuTestModule } from '../../../test.module';
import { MockEventManager } from '../../../helpers/mock-event-manager.service';
import { MockActiveModal } from '../../../helpers/mock-active-modal.service';
import { ACCENTIDADDFDeleteDialogComponent } from 'app/entities/accentidaddf/accentidaddf-delete-dialog.component';
import { ACCENTIDADDFService } from 'app/entities/accentidaddf/accentidaddf.service';

describe('Component Tests', () => {
  describe('ACCENTIDADDF Management Delete Component', () => {
    let comp: ACCENTIDADDFDeleteDialogComponent;
    let fixture: ComponentFixture<ACCENTIDADDFDeleteDialogComponent>;
    let service: ACCENTIDADDFService;
    let mockEventManager: MockEventManager;
    let mockActiveModal: MockActiveModal;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [JhipsterSampleTCuTestModule],
        declarations: [ACCENTIDADDFDeleteDialogComponent]
      })
        .overrideTemplate(ACCENTIDADDFDeleteDialogComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(ACCENTIDADDFDeleteDialogComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(ACCENTIDADDFService);
      mockEventManager = TestBed.get(JhiEventManager);
      mockActiveModal = TestBed.get(NgbActiveModal);
    });

    describe('confirmDelete', () => {
      it('Should call delete service on confirmDelete', inject(
        [],
        fakeAsync(() => {
          // GIVEN
          spyOn(service, 'delete').and.returnValue(of({}));

          // WHEN
          comp.confirmDelete(123);
          tick();

          // THEN
          expect(service.delete).toHaveBeenCalledWith(123);
          expect(mockActiveModal.closeSpy).toHaveBeenCalled();
          expect(mockEventManager.broadcastSpy).toHaveBeenCalled();
        })
      ));

      it('Should not call delete service on clear', () => {
        // GIVEN
        spyOn(service, 'delete');

        // WHEN
        comp.cancel();

        // THEN
        expect(service.delete).not.toHaveBeenCalled();
        expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
      });
    });
  });
});
