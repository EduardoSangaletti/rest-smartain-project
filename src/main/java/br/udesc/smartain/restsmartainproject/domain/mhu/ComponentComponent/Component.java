package br.udesc.smartain.restsmartainproject.domain.mhu.ComponentComponent;

import br.udesc.smartain.restsmartainproject.domain.mhu.BrandComponent.Brand;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.Comment;

import java.util.Objects;

@Entity
@Table(schema = "mhu", name = "tbcomponente")
@Comment("Tabela de cadastro dos componentes das máquinas")
public class Component {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comcodigo")
    @Comment("Código sequencial do componente")
    private Integer id;

    @Column(name = "comnome", length = 250)
    @NotBlank
    @Size(min = 3, max = 250, message = "O nome do componente deve conter entre 3 e 250 caracteres.")
    @Comment("Nome do componente")
    private String name;

    @Column(name = "comdadostec", length = 1000)
    @NotBlank
    @Size(min = 3, max = 1000, message = "Os dados técnicos do componente deve conter entre 3 e 1000 caracteres.")
    @Comment("Dados e especificações técnicas do componente")
    private String technicalData;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "marcodigo")
    @Comment("Código da marca")
    private Brand brand;

    public Component() {

    }

    public Component(Integer id, String name, String technicalData, Brand brand) {
        this.id = id;
        this.name = name;
        this.technicalData = technicalData;
        this.brand = brand;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTechnicalData() {
        return technicalData;
    }

    public void setTechnicalData(String technicalData) {
        this.technicalData = technicalData;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Component{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", technicalData='" + technicalData + '\'' +
                ", brand=" + brand +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Component component = (Component) o;
        return Objects.equals(id, component.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
