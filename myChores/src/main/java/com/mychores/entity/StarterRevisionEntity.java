package com.mychores.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

@Entity
@Table(name="system_revision") // just rename revinfo to system_revision
@RevisionEntity
public class StarterRevisionEntity extends DefaultRevisionEntity {

}
