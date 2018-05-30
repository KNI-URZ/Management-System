package com.kni.managementSystem.project;

import com.kni.managementSystem.contributor.Contributor;
import com.kni.managementSystem.type.Type;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Marcin Mrukowicz on 2018-01-31.
 */

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar")
    private String name;

    @Column(columnDefinition = "varchar")
    private String repositoryUrl;

    @ManyToMany(cascade = {})
    @JoinTable(name="project_contributor", joinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "contributor_id", referencedColumnName = "id"))
    private Set<Contributor> contributors;

    @ManyToOne(targetEntity = Type.class, fetch = FetchType.LAZY)
    private Type typeOfProject;

    @Column
    private Boolean isArchived;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRepositoryUrl() {
        return repositoryUrl;
    }

    public void setRepositoryUrl(String repositoryUrl) {
        this.repositoryUrl = repositoryUrl;
    }

    public Set<Contributor> getContributors() {
        return contributors;
    }

    public void setContributors(Set<Contributor> contributors) {
        this.contributors = contributors;
    }

    public Type getTypeOfProject() {
        return typeOfProject;
    }

    public void setTypeOfProject(Type typeOfProject) {
        this.typeOfProject = typeOfProject;
    }

    public Boolean getArchived() {
        return isArchived;
    }

    public void setArchived(Boolean archived) {
        isArchived = archived;
    }
}
