package br.udesc.smartain.restsmartainproject.domain.mhu.MachineComponent;

import br.udesc.smartain.restsmartainproject.domain.glo.ManufacturingUnitComponent.ManufacturingUnit;
import br.udesc.smartain.restsmartainproject.domain.mhu.MachineModelComponent.MachineModel;
import br.udesc.smartain.restsmartainproject.domain.mhu.ProductionCellComponent.ProductionCell;
import br.udesc.smartain.restsmartainproject.domain.mhu.SectorComponent.Sector;
import br.udesc.smartain.restsmartainproject.domain.states.RegisterState;
import jakarta.persistence.*;
import org.hibernate.annotations.Comment;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(schema = "mhu", name = "tbmaquina")
@Comment("Tabela de cadastros de máquinas dos setores/células de produção")
public class Machine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maqcodigo")
    @Comment("Código sequencial da máquina")
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "setcodigo")
    @Comment("Código do setor")
    private Sector sector;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "clpcodigo")
    @Comment("Código da célula de produção")
    private ProductionCell productionCell;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "unfcodigo")
    @Comment("Código da unidade fabril")
    private ManufacturingUnit unit;

    @Column(name = "maqdadostec", length = 1000)
    @Comment("Dados técnicos do modelo de máquina")
    private String technicalData;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "momcodigo")
    @Comment("Código do modelo de máquina")
    private MachineModel machineModel;

    @Column(name = "maqtag", length = 7, nullable = false)
    @Comment("Tag da máquina (Ex.: ABC-001)")
    private String tag;

    @Temporal(TemporalType.DATE)
    @Column(name = "maqdataaquisicao")
    @Comment("Data de aquisição da máquina")
    private LocalDate acquisitionDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "maqdatcad")
    @Comment("Data de cadastro da máquina")
    private LocalDateTime createdDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "maqdatexpiragarantia")
    @Comment("Data de expiração da garantia da máquina")
    private LocalDate warrantyExpDate;

    @Column(name = "maqgarantia")
    @Comment("Indica de a máquina está na garantia (0-Não, 1-Sim)")
    private Short warranty;

    @Column(name = "maqstatus")
    @Comment("Status da máquina (1-Ativo 2-Inativo)")
    private Short status;

    public Machine() {

    }

    public Machine(Integer id, Sector sector, ProductionCell productionCell, ManufacturingUnit unit, String technicalData, MachineModel machineModel, String tag, LocalDate acquisitionDate, LocalDateTime createdDate, LocalDate warrantyExpDate, Short warranty, RegisterState status) {
        this.id = id;
        this.sector = sector;
        this.productionCell = productionCell;
        this.unit = unit;
        this.technicalData = technicalData;
        this.machineModel = machineModel;
        this.tag = tag;
        this.acquisitionDate = acquisitionDate;
        this.createdDate = createdDate;
        this.warrantyExpDate = warrantyExpDate;
        this.warranty = warranty;
        this.status = status.getValue();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public ManufacturingUnit getUnit() {
        return unit;
    }

    public void setUnit(ManufacturingUnit unit) {
        this.unit = unit;
    }

    public String getTechnicalData() {
        return technicalData;
    }

    public void setTechnicalData(String technicalData) {
        this.technicalData = technicalData;
    }

    public MachineModel getMachineModel() {
        return machineModel;
    }

    public void setMachineModel(MachineModel machineModel) {
        this.machineModel = machineModel;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public LocalDate getAcquisitionDate() {
        return acquisitionDate;
    }

    public void setAcquisitionDate(LocalDate acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getWarrantyExpDate() {
        return warrantyExpDate;
    }

    public void setWarrantyExpDate(LocalDate warrantyExpDate) {
        this.warrantyExpDate = warrantyExpDate;
    }

    public Short getWarranty() {
        return warranty;
    }

    public void setWarranty(Short warranty) {
        this.warranty = warranty;
    }

    public RegisterState getStatus() {
        return RegisterState.valueOf(status);
    }

    public void setStatus(RegisterState status) {
        this.status = status.getValue();
    }

    public ProductionCell getProductionCell() {
        return productionCell;
    }

    public void setProductionCell(ProductionCell productionCell) {
        this.productionCell = productionCell;
    }

    @Override
    public String toString() {
        return "Machine{" +
                "id=" + id +
                ", sector=" + sector +
                ", productionCell=" + productionCell +
                ", unit=" + unit +
                ", technicalData='" + technicalData + '\'' +
                ", machineModel=" + machineModel +
                ", tag='" + tag + '\'' +
                ", acquisitionDate=" + acquisitionDate +
                ", createdDate=" + createdDate +
                ", warrantyExpDate=" + warrantyExpDate +
                ", warranty=" + warranty +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Machine machine = (Machine) o;
        return Objects.equals(id, machine.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
